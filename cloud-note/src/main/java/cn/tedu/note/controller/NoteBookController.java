package cn.tedu.note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.tedu.note.service.NoteBookService;

@Controller
@RequestMapping("/notebook")
public class NoteBookController extends AbstractExceptionController {
	
	@Resource(name="notebookService")
	private NoteBookService nbs;
	
	@RequestMapping("/list.do")
	@ResponseBody
    public JsonResult notebookList(String userId){
		List<Map<String,Object>> list = nbs.listNoteBooks(userId);
		return new JsonResult(list);
    }
	
	@RequestMapping("/page.do")
	@ResponseBody
    public JsonResult notebookList(String userId,Integer page){
		List<Map<String,Object>> list = nbs.listNoteBooks(userId, page, null);
		return new JsonResult(list);
    }
}
