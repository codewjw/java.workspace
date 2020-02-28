package cn.tedu.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Resource(name="userDao")
	private UserDao uDao;
	
	public User login(String name, String password) {
		User user = uDao.findByName(name);
		if(user!=null&&user.getPassword().equals(password)){
		   System.out.println(user);
		   return user;
		}
		return null;
	}

}
