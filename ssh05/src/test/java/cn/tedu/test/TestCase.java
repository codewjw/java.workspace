package cn.tedu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

public class TestCase {
   ApplicationContext ctx;
   
   @Before 
   public void init(){
	   ctx = new ClassPathXmlApplicationContext("spring-context.xml");
   }
   
   @Test
   public void testUserDao(){
	   UserDao uDao = ctx.getBean("userDao",UserDao.class);
	   User user = uDao.findByName("jack");
	   System.out.println(user);
   }
   
   @Test
   public void testUserService(){
	   UserService uService = ctx.getBean("userService",UserService.class);
	   User user = uService.login("jack", "123456");
	   System.out.println(user);
   }
}
