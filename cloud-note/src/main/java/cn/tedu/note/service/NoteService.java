package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.Note;

public interface NoteService {
   public List<Map<String,Object>> findNoteByNoteBookId(String notebookId) 
		   throws NoteBookNotFoundException;
   
   public List<Map<String,Object>> findNoteByNoteBookId2(String notebookId) 
		   throws NoteBookNotFoundException;
   
   public Note findNoteById(String noteId) throws NoteNotFoundException;
   
   public String addNote(String notebookId,String userId,String title)
   throws NoteNotFoundException,NoteBookNotFoundException,UserNotFoundException;
   
   public String updateNote(String noteId,String noteTitle,String noteBody)
   throws NoteNotFoundException;
   
   public Map<String,Object> updateNoteStatus(String noteId,String noteStatusId)
		   throws NoteNotFoundException;
   
   
   public String MoveNote(String noteId,String notebookId)
		   throws NoteNotFoundException,NoteBookNotFoundException;
   public String deleteNote(String noteId) throws NoteNotFoundException;
   public int deleteNotes(String... noteIds) throws NoteNotFoundException;
}
