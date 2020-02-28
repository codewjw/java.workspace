package cn.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.poem.dao.UserDao;
import cn.poem.entity.User;

public class TestCase {
	
	private UserDao userDao;
	
	@Before
	public void init(){
		ApplicationContext cpx = 
				new ClassPathXmlApplicationContext("conf/spring-mvc.xml",
				"conf/spring-mybatis.xml");
		userDao = cpx.getBean("userDao",UserDao.class);
	}
	
	@Test
	public void testUserDao(){
		User user = userDao.findUserByName("test1");
		System.out.println(user);
	}
	
	@Test
	public void testInsertUserDao(){
		User user = new User();
		user.setPassword("123456");
		user.setName("chenwj");
		user.setNick("hero");
		user.setEmail("jryutian@126.com");
		int num = userDao.insertUser(user);
		System.out.println(num);
	}
	
	
	
}
