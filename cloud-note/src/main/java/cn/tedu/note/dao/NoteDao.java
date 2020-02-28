package cn.tedu.note.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.Note;
@Repository
public interface NoteDao {
   
	public List<Map<String,Object>> findNotesByNotebookId(String notebookId);
	public List<Map<String,Object>> findNotesByNotebookId2(String notebookId);
	public Note findNoteById(String nodeId);
	public int addNote(Note note);
	public int updateNote(Note note);
	public int deleteNote(String noteId);
	public int deleteNotes(@Param("ids") String ...ids);
    
	//多参数请求
	public List<Map<String,Object>> findNotes(
			@Param("notebookId") String notebookId,
			@Param("noteId") String noteId,
			@Param("statusId") String statusId);
}
