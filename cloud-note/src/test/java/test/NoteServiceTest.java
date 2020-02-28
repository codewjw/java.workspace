package test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.service.NoteService;

public class NoteServiceTest extends BaseTest{
	
	private NoteService ns;
	@Before
	public void test(){
		  ns = cpxac.getBean("noteService",NoteService.class);
	}
	
   @Test
   public void testDeleteNotes(){
	   String id1="f74d03aa-d01d-4989-95e8-4757d6ca8a2a";
	   String id2="ss19055-30e8-4cdc-bfac-97c6bad9518f";
	   String id3="djj8349-iadksa0-8iasdi";
	   String id4="fsaf-as-df-asdf-as-df-dsa";
	   
	   int n = ns.deleteNotes(id1,id2,id3,id4);
	   System.out.println(n);
   }
   
   
   
}
