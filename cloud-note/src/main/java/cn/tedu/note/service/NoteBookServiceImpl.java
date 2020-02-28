package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.NoteBookDao;
import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Service("notebookService")
public class NoteBookServiceImpl implements NoteBookService{
	@Resource(name="noteBookDao")
	private NoteBookDao nbdao;
	
	@Resource(name="userdao")
	private UserDao udao;
	
	@Value("#{jdbc.pageSize}")
	private int pageSize;
	
	public List<Map<String, Object>> listNoteBooks(String userId) 
			throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("用户未登陆！");
		}
		User user = udao.findUserById(userId);
		if(user == null){
			throw new UserNotFoundException("用户无效！");
		}
		return nbdao.findNoteBookByUserId(userId);
	}

	public List<Map<String, Object>> listNoteBooks(String userId,
			Integer page, Integer pgSize)
			throws UserNotFoundException {
		if(userId==null||userId.trim().isEmpty()){
			throw new UserNotFoundException("用户未登陆！");
		}
		if(page==null){
			page = 0;
		}
		if(pgSize!=null){
			pageSize = pgSize;
		}
		int start = page*pageSize;
		String table = "cn_notebook";
		return nbdao.findNoteBooksByPage(userId, start, pageSize, table);
	}
    
}
