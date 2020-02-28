package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.NoteBookDao;

public class NoteBookDaoTest extends BaseTest{

	private NoteBookDao nbdao;
	@Before
	public void initTest(){
		nbdao = cpxac.getBean("noteBookDao",NoteBookDao.class);
	}
	@Test
	public void test1(){
		String userId="52f9b276-38ee-447f-a3aa-0d54e7a736e4";
		List<Map<String,Object>> list = nbdao.findNoteBookByUserId(userId);
		for(Map<String,Object> p:list){
		  System.out.println(p);
		}
	}
}
