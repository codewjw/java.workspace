package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.service.NoteBookService;



public class NotebookServiceTest extends BaseTest{
  
	private NoteBookService nbs;
	
	@Before
	public void test1(){
		  nbs = cpxac.getBean("notebookService",NoteBookService.class);
	}
	
	@Test
	public void test2(){
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		List<Map<String,Object>> list = nbs.listNoteBooks(userId, 0,null);
		System.out.println(list.size());
		for(Map<String,Object> p:list){
		  System.out.println(p);
		}
	}
}
