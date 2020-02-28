package test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.PostDao;
import cn.tedu.note.entity.Post;

public class PostDaoTest extends BaseTest {
   
	PostDao postDao;
	
	@Before
	public void test1(){
		postDao = cpxac.getBean("postDao",PostDao.class);
	}
	
	@Test
	public void test2(){
		Post post = postDao.findPostById(1);
		System.out.println(post);
	}
}
