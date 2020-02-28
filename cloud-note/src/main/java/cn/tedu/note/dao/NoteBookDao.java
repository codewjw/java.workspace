package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.NoteBook;
@Repository
public interface NoteBookDao {
    
	List<Map<String,Object>> findNoteBookByUserId(String userId);
	
	NoteBook findNoteBookById(String noteBookId);
	
	List<Map<String,Object>> findNoteBooksByPage(
			@Param("userId") String userId,
			@Param("start") int start,
			@Param("pageSize") int pageSize,
			@Param("table") String table);
}
