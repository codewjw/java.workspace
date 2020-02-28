package cn.tedu.note.service;

import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

@Service("userService") //��д�������ݣ����Ȱ�ID�ң��Ҳ����ٰ������ң�һ��д��
public class UserServiceImpl implements UserService {
	
	@Resource(name="userdao") //��д�Ȱ�������ȥ�ң�����Ҳ������ٰ�����ȥ��
	private UserDao userDao;
	
	@Value("#{jdbc.salt}")
	private String salt;
	
	//����
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
			 throw new UserNotFoundException("�û�Ϊ��");
		 }
		 if(passwd==null||passwd.trim().isEmpty()){
			 throw new PasswordException("����Ϊ��");
		 }
		 if(user==null){
			 throw new UserNotFoundException("�û����������");
		 }
		 String pwd = DigestUtils.md5Hex(passwd+salt);
		 if(!pwd.equals(user.getUserPasswd())){
			 throw new PasswordException("�����������");
		 }
		return user;
	}
	
	/*
	 *ע��
	 */
	public User regist(String name,String passwd,
			String confirm,String nick) 
			throws UserHadExistException,PasswordException{
		if(name==null||name.trim().isEmpty()){
			throw new UserHadExistException("�û���Ϊ��");
		}
		if(passwd==null||passwd.trim().isEmpty()){
			throw new PasswordException("����Ϊ��");
		}
		User user = userDao.findUserByName(name);
		if(user!=null){
			throw new UserHadExistException("�û����ѱ�ע��");
		}
		if(!passwd.equals(confirm)){
			throw new PasswordException("�����������벻һ�£�");
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
			throw new RuntimeException("���ʧ��");
		}
		return user;
	}

}
