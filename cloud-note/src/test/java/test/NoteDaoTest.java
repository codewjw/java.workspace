package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.NoteDao;

public class NoteDaoTest extends BaseTest{
	
	private NoteDao ndao;
	
	@Before
	public void initTest(){
		ndao = cpxac.getBean("noteDao",NoteDao.class);
	}
	@Test
	public void test1(){
		String noteBookId = "516f6f4f-eaa3-4c76-84ff-530b92c7f64d";
		List<Map<String,Object>> list = ndao.findNotesByNotebookId(noteBookId);
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
	}
	
	@Test
	public void testDeleteNotes(){
		   String id1="7c44e29b-0622-43dd-9f50-7103b1461bfe";
		   String id2="88523a80-caba-4e7a-bc50-3f25c08e2f63";
		   int n = ndao.deleteNotes(id1,id2);
		   System.out.println(n);
	   }
}
