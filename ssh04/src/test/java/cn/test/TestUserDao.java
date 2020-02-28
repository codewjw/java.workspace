package cn.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class TestUserDao {
	
	ClassPathXmlApplicationContext cpx;
	@Before
	public void test(){
	  cpx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	}

	@Test
	public void test1(){
		UserDao udao = cpx.getBean("userDao",UserDao.class);
		User user = new User();
		user.setId(null);
		user.setName("Tom");
		udao.Save(user);
	}
}
