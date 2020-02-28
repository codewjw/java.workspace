package test;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.PasswordException;
import cn.tedu.note.service.UserNotFoundException;
import cn.tedu.note.service.UserService;

public class UserServiceTest extends BaseTest {

	private UserService us;
	@Before
	public void test(){
		  us = cpxac.getBean("userService",UserService.class);
	}
	@Test
    public void test1(){
      String userName = "demo";
      String passwd ="123456";
      User user =null;
      try {
		 user = us.Login(userName, passwd);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (PasswordException e) {
			e.printStackTrace();
		}
      System.out.println(user);
    }
	
	
	@Test
    public void test2(){
		String name = "andy";
		String passwd = "123456";
		String confirm = "123456";
		String nick = "хавЃ";
		User user = us.regist(name, passwd, confirm, nick);
		System.out.println(user);
	}
}
