package cn.tedu.note.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.note.dao.NoteBookDao;
import cn.tedu.note.dao.NoteDao;
import cn.tedu.note.dao.StarDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.Note;
import cn.tedu.note.entity.NoteBook;
import cn.tedu.note.entity.User;

@Service("noteService")
public class NoteServiceImpl implements NoteService{

	@Resource(name="noteDao")
	private NoteDao nd;
	
	@Resource(name="noteBookDao")
	private NoteBookDao nbd;
	
	@Resource(name="userdao")
	private UserDao ud;
	
	@Resource(name="starService")
	private StarService ss;
	
	@Transactional(readOnly=true)
	public List<Map<String, Object>> findNoteByNoteBookId(String notebookId) 
			throws NoteBookNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("IDΪ��");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("�˱ʼǱ�������");
		}
		//List<Map<String,Object>> list = nd.findNotesByNotebookId(notebookId);
		List<Map<String,Object>> list = nd.findNotes(notebookId, null, "1");
		return list;
	}

	public Note findNoteById(String noteId)
			throws NoteNotFoundException{
		       if(noteId==null||noteId.trim().isEmpty()){
		    	   throw new NoteNotFoundException("IDΪ��");
		       }
		       Note note = nd.findNoteById(noteId);
		       /*if(note==null){
		    	   throw new NoteNotFoundException("�ñʼ���������");
		       }*/
			return note;
	}

	@Transactional
	//@Transactional(propagation=Propagation.NESTED)
	//@Transactional(isolation=Isolation.READ_COMMITTED) //Ĭ��Ϊ���ָ���
	public String addNote(String notebookId, String userId,String title)
			throws NoteNotFoundException,NoteBookNotFoundException, UserNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("�ʼǱ�IdΪ��");
		}
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("�û�Ϊ��");
		}
		if(title==null||title.trim().isEmpty()){
			throw new NoteNotFoundException("�ʼ���Ϊ��");
		}
		User user = ud.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("�û�������");
		}
		NoteBook notebook = nbd.findNoteBookById(notebookId);
		if(notebook==null){
			throw new NoteBookNotFoundException("�ʼǱ�������");
		}
		Note note = new Note();
		note = setNote(note,notebookId,userId,title);
		int n = nd.addNote(note);
		if(n!=1){
			throw new NoteNotFoundException("����ʧ��");
		}
		//�����񴫲���addStars�����У�����Ϊһ������
		ss.addStars(userId,-25);
		return note.getNoteId();
	}
 
	public Note setNote(Note note,String notebookId,String userId,String title){
		String uid = UUID.randomUUID().toString();
		Date date = new Date();
		//Timestamp ts = new Timestamp(date.getTime());
		note.setNoteId(uid);
		note.setNotebookId(notebookId);
		note.setUserId(userId);
		note.setNoteStatusId("1");
		note.setNoteTypeId("1");
		note.setNoteTitle(title);
		note.setNoteBody("");
		note.setNoteCreateTime(date.getTime());
		note.setNoteLastModifyTime(date.getTime());
		return note;
	}
    
	@Transactional
	public String updateNote(String noteId, String noteTitle, String noteBody)
			throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("�ʼ�IdΪ��");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("�ʼǲ�����");
		}
		String title = note.getNoteTitle();
		if((noteTitle==null||noteTitle.trim().isEmpty())&&
			(noteBody==null||noteBody.trim().isEmpty())){
			throw new NoteNotFoundException("�ʼǱ��������ͬΪ��");
		}
		
		if(noteTitle!=null&&!noteTitle.trim().isEmpty()&&
				!noteTitle.equals(note.getNoteTitle())){
			note.setNoteTitle(noteTitle);
		}else{
			note.setNoteTitle(null);
		}
		if(noteBody!=null&&!noteBody.trim().isEmpty()&&
				!noteBody.equals(note.getNoteBody())){
			note.setNoteBody(noteBody);
		}else{
			note.setNoteBody(null);
		}
	    note.setNoteLastModifyTime(System.currentTimeMillis());
		int n = nd.updateNote(note);
		if(n!=1){
			throw new NoteNotFoundException("����ʧ��");
		}
		return title;
	}

	public String MoveNote(String noteId, String notebookId) 
			throws NoteNotFoundException, NoteBookNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("�ʼ�IdΪ��");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("�ʼǲ�����");
		}
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("�ʼǱ�IdΪ��");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("�˱ʼǱ�������");
		}
	    note.setNotebookId(notebookId);
	    nd.updateNote(note);
		return note.getNoteTitle();
	}
    
	@Transactional
	public String deleteNote(String noteId) throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("�ʼ�IdΪ��");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("�ʼǲ�����");
		}
		String title = note.getNoteTitle();
		int n=nd.deleteNote(noteId);
		if(n!=1){
			throw new NoteNotFoundException("ɾ��ʧ��");
		}
		return title;
	}
	
	//���������ǿ���...(����������)����[],Ҳ��ʾ����,�������������ת��
	@Transactional
	public int deleteNotes(String... noteIds)
			throws NoteNotFoundException {
		for(String noteId:noteIds){
			int n = nd.deleteNote(noteId);
			if(n!=1){
				throw new NoteNotFoundException("ɾ��ʧ��");
			}
		}
		return noteIds.length;
	}

	public List<Map<String, Object>> findNoteByNoteBookId2(String notebookId) 
			throws NoteBookNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("IDΪ��");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("�˱ʼǱ�������");
		}
		List<Map<String,Object>> list = nd.findNotesByNotebookId2(notebookId);
		return list;
	}

	public Map<String, Object> updateNoteStatus(String noteId, String noteStatusId) 
			throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("�ʼ�IdΪ��");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("�ʼǲ�����");
		}
		if(noteStatusId==null||noteStatusId.trim().isEmpty()){
             note.setNoteStatusId("1");
		}else{
		     note.setNoteStatusId(noteStatusId);
		}
		String title = note.getNoteTitle();
		Map<String,Object> noteTitle = new HashMap<String,Object>();
		noteTitle.put("noteTitle", title);
		note = setUpdateStatus(note);
		nd.updateNote(note);
		return noteTitle;
	}

	private Note setUpdateStatus(Note note) {
		note.setNoteBody(null);
		note.setNoteTitle(null);
		note.setNoteLastModifyTime(System.currentTimeMillis());
		note.setNoteTypeId(null);
		note.setNoteCreateTime(null);
		note.setUserId(null);
		note.setNotebookId(null);
		return note;
	}
}
