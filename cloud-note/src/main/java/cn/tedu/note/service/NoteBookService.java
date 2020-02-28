package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

public interface NoteBookService {
   public List<Map<String,Object>> listNoteBooks(String userId)
		   throws UserNotFoundException;
   public List<Map<String,Object>> listNoteBooks(String userId,
		   Integer page,Integer pageSize)
		   throws UserNotFoundException;
}
