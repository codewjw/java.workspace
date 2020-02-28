package cn.poem.serviceImpl;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.poem.dao.UserDao;
import cn.poem.entity.User;
import cn.poem.exception.PassWordNotFoundException;
import cn.poem.exception.UserNotFoundException;
import cn.poem.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Value("#{jdbc.md5psw}")
	private String md5psw;
	
	public int regist(String name,String password,
	String confirmPsw,String nick,String email) throws 
	UserNotFoundException, PassWordNotFoundException {
		if(name==null||name.trim().isEmpty()){
			throw new UserNotFoundException("�û���Ϊ��");
		}
		if(password==null||password.isEmpty()){
			throw new PassWordNotFoundException("����Ϊ��");
		}
		if(!password.equals(confirmPsw)){
			throw new PassWordNotFoundException("�����������벻һ�£�");
		}
		User user = userDao.findUserByName(name);
		if(user!=null){
			throw new UserNotFoundException("�û����Ѿ���ע��");
		}
		user = new User();
		password = DigestUtils.md5Hex(password+md5psw);
		user = setUser(name, password,nick, email, user);
		int num = userDao.insertUser(user);
		if(num!=1){
			throw new RuntimeException("ע��ʧ�ܣ�");
		}
		return num;
	}

	public User setUser(String name,String password,
			String nick,String email,User user) {
		user.setName(name);
		user.setPassword(password);
		user.setNick(nick);
		user.setEmail(email);
		return user;
	}

	public User login(String name,String password) 
			throws UserNotFoundException, PassWordNotFoundException {
		if(name==null||name.trim().isEmpty()){
			throw new UserNotFoundException("�û���Ϊ��");
		}
		if(password==null||password.isEmpty()){
			throw new PassWordNotFoundException("����Ϊ��");
		}
		User user = userDao.findUserByName(name);
		if(user==null){
			throw new UserNotFoundException("�û�������ȷ!");
		}
		password = DigestUtils.md5Hex(password+md5psw);
		if(!password.equals(user.getPassword())){
			throw new PassWordNotFoundException("���벻��ȷ!");
		}
		return user;
	}
}
