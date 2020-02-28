package cn.tedu.note.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.note.entity.Note;
import cn.tedu.note.service.NoteNotFoundException;
import cn.tedu.note.service.NoteService;

@Controller
@RequestMapping("/note")
public class NoteController extends AbstractExceptionController{
    
	@Resource(name="noteService")
	private NoteService notes;
	
	@RequestMapping("/findnotes.do")
	@ResponseBody
	public JsonResult findNoteByNoteBookId(String notebookId){
		List<Map<String,Object>> noteList = notes.findNoteByNoteBookId(notebookId);
		return new JsonResult(noteList);
	}
	
	@RequestMapping("/findnote.do")
	@ResponseBody
	public JsonResult findNoteById(String noteId){
		Note note = notes.findNoteById(noteId);
		return new JsonResult(note);
	}
	
	@ExceptionHandler(NoteNotFoundException.class)
	@ResponseBody
	public JsonResult handlerNoteNotFoundEx(NoteNotFoundException e) {
		return new JsonResult(e);
	}
	
	@RequestMapping("/addnote.do")
	@ResponseBody
	public JsonResult addNote(String notebookId,String userId,String title){
		String noteId=notes.addNote(notebookId, userId, title);
		return new JsonResult(noteId);
	}
	
	@RequestMapping("/updatenote.do")
	@ResponseBody
	public JsonResult updateNote(String noteId,String noteTitle,
			String noteBody){
		noteTitle=notes.updateNote(noteId, noteTitle, noteBody);
		Map<String,Object> title = new HashMap<String,Object>();
		title.put("noteTitle", noteTitle);
		return new JsonResult(title);
	}
	
	@RequestMapping("/movenote.do")
	@ResponseBody
	public JsonResult MoveNote(String noteId,String notebookId){
		String noteTitle=notes.MoveNote(noteId, notebookId);
		Map<String,Object> title = new HashMap<String,Object>();
		title.put("noteTitle", noteTitle);
		return new JsonResult(title);
	}
	
	@RequestMapping("/deletenote.do")
	@ResponseBody
	public JsonResult deleteNote(String noteId){
		String noteTitle=notes.deleteNote(noteId);
		Map<String,Object> title = new HashMap<String,Object>();
		title.put("noteTitle", noteTitle);
		return new JsonResult(title);
	}
	
	@RequestMapping("/findnotesbystate.do")
	@ResponseBody
	public JsonResult findNoteByNoteBookId2(String notebookId){
		List<Map<String,Object>> noteList = notes.findNoteByNoteBookId2(notebookId);
		return new JsonResult(noteList);
	}
	
	@RequestMapping("/updatestatus.do")
	@ResponseBody
	public JsonResult updateNoteStatus(String noteId,String noteStatusId){
		Map<String,Object> noteTitle = notes.updateNoteStatus(noteId,noteStatusId);
		return new JsonResult(noteTitle);
	}
}
