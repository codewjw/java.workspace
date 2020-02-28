package test;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

public class UserDaoTest extends BaseTest{

	 private UserDao dao;
	 @Before
	 public void test(){
		 dao = cpxac.getBean("userdao",UserDao.class);
	 }
	
	 @Test
	 public void test1(){
		User user = dao.findUserByName("demo");
		System.out.println(user);
	 }
	 @Test
	 public void test2(){
		String uid = UUID.randomUUID().toString();
		String name = "Tom";
		String passwd = DigestUtils.md5Hex("123456"+"今天你吃了么?");
		System.out.println(passwd);
		User user = new User(); 
		user.setUserId(uid);
		user.setUserName(name);
		user.setUserPasswd(passwd);
		user.setUserNick("");
		user.setUserToken("");
		int n = dao .addUser(user);
		System.out.println(n);
	 }
}
