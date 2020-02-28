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
			throw new NoteBookNotFoundException("ID为空");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("此笔记本不存在");
		}
		//List<Map<String,Object>> list = nd.findNotesByNotebookId(notebookId);
		List<Map<String,Object>> list = nd.findNotes(notebookId, null, "1");
		return list;
	}

	public Note findNoteById(String noteId)
			throws NoteNotFoundException{
		       if(noteId==null||noteId.trim().isEmpty()){
		    	   throw new NoteNotFoundException("ID为空");
		       }
		       Note note = nd.findNoteById(noteId);
		       /*if(note==null){
		    	   throw new NoteNotFoundException("该笔记暂无内容");
		       }*/
			return note;
	}

	@Transactional
	//@Transactional(propagation=Propagation.NESTED)
	//@Transactional(isolation=Isolation.READ_COMMITTED) //默认为此种隔离
	public String addNote(String notebookId, String userId,String title)
			throws NoteNotFoundException,NoteBookNotFoundException, UserNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("笔记本Id为空");
		}
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("用户为空");
		}
		if(title==null||title.trim().isEmpty()){
			throw new NoteNotFoundException("笔记名为空");
		}
		User user = ud.findUserById(userId);
		if(user==null){
			throw new UserNotFoundException("用户不存在");
		}
		NoteBook notebook = nbd.findNoteBookById(notebookId);
		if(notebook==null){
			throw new NoteBookNotFoundException("笔记本不存在");
		}
		Note note = new Note();
		note = setNote(note,notebookId,userId,title);
		int n = nd.addNote(note);
		if(n!=1){
			throw new NoteNotFoundException("增加失败");
		}
		//当事务传播到addStars方法中，整合为一个事务
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
			throw new NoteNotFoundException("笔记Id为空");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("笔记不存在");
		}
		String title = note.getNoteTitle();
		if((noteTitle==null||noteTitle.trim().isEmpty())&&
			(noteBody==null||noteBody.trim().isEmpty())){
			throw new NoteNotFoundException("笔记标题和内容同为空");
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
			throw new NoteNotFoundException("更新失败");
		}
		return title;
	}

	public String MoveNote(String noteId, String notebookId) 
			throws NoteNotFoundException, NoteBookNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("笔记Id为空");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("笔记不存在");
		}
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("笔记本Id为空");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("此笔记本不存在");
		}
	    note.setNotebookId(notebookId);
	    nd.updateNote(note);
		return note.getNoteTitle();
	}
    
	@Transactional
	public String deleteNote(String noteId) throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("笔记Id为空");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("笔记不存在");
		}
		String title = note.getNoteTitle();
		int n=nd.deleteNote(noteId);
		if(n!=1){
			throw new NoteNotFoundException("删除失败");
		}
		return title;
	}
	
	//接收数组是可用...(不定长参数)代替[],也表示数组,编译器会帮我们转换
	@Transactional
	public int deleteNotes(String... noteIds)
			throws NoteNotFoundException {
		for(String noteId:noteIds){
			int n = nd.deleteNote(noteId);
			if(n!=1){
				throw new NoteNotFoundException("删除失败");
			}
		}
		return noteIds.length;
	}

	public List<Map<String, Object>> findNoteByNoteBookId2(String notebookId) 
			throws NoteBookNotFoundException {
		if(notebookId==null||notebookId.trim().isEmpty()){
			throw new NoteBookNotFoundException("ID为空");
		}
		NoteBook nb = nbd.findNoteBookById(notebookId);
		if(nb==null){
			throw new NoteBookNotFoundException("此笔记本不存在");
		}
		List<Map<String,Object>> list = nd.findNotesByNotebookId2(notebookId);
		return list;
	}

	public Map<String, Object> updateNoteStatus(String noteId, String noteStatusId) 
			throws NoteNotFoundException {
		if(noteId==null||noteId.trim().isEmpty()){
			throw new NoteNotFoundException("笔记Id为空");
		}
		Note note = nd.findNoteById(noteId);
		if(note==null){
			throw new NoteNotFoundException("笔记不存在");
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
