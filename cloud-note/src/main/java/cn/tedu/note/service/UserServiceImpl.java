package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Service("userService") //不写括号内容，会先按ID找，找不到再按类型找，一般写上
public class UserServiceImpl implements UserService {
	
	@Resource(name="userdao") //不写先按变量名去找，如果找不到，再按类型去找
	private UserDao userDao;
	
	@Value("#{jdbc.salt}")
	private String salt;
	
	//事务
	//@Transactional
	public User Login(String name, String passwd)  
			throws UserNotFoundException,PasswordException{
		 String s = null;
		 /*try{
			 s.charAt(0);
		 }catch(Exception e){
			 e.printStackTrace();
		 }*/
		 System.out.println("Login");
		 User user = userDao.findUserByName(name);
		 if(name==null||name.trim().isEmpty()){
			 throw new UserNotFoundException("用户为空");
		 }
		 if(passwd==null||passwd.trim().isEmpty()){
			 throw new PasswordException("密码为空");
		 }
		 if(user==null){
			 throw new UserNotFoundException("用户名输入错误");
		 }
		 String pwd = DigestUtils.md5Hex(passwd+salt);
		 if(!pwd.equals(user.getUserPasswd())){
			 throw new PasswordException("密码输入错误");
		 }
		return user;
	}
	
	/*
	 *注册
	 */
	public User regist(String name,String passwd,
			String confirm,String nick) 
			throws UserHadExistException,PasswordException{
		if(name==null||name.trim().isEmpty()){
			throw new UserHadExistException("用户名为空");
		}
		if(passwd==null||passwd.trim().isEmpty()){
			throw new PasswordException("密码为空");
		}
		User user = userDao.findUserByName(name);
		if(user!=null){
			throw new UserHadExistException("用户名已被注册");
		}
		if(!passwd.equals(confirm)){
			throw new PasswordException("两次输入密码不一致！");
		}
		if(nick==null||nick.trim().isEmpty()){
			nick = name;
		}
		String userId = UUID.randomUUID().toString();
		String token = "";
		passwd = DigestUtils.md5Hex(passwd+salt);
		user = new User(userId,name,passwd,token,nick);
		int count = userDao.addUser(user);
		if(count!=1){
			throw new RuntimeException("添加失败");
		}
		return user;
	}

}
