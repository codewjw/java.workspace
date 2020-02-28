package cn.tedu.netctoss.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.netctoss.dao.AdminDao;
import cn.tedu.netctoss.entity.Admin;

/*
 * 业务层的实现,业务层的注解
 * @Service("loginService"),其中loginService为bena的id
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="adminDAO")
    private AdminDao aDao;
	
	public Admin checkLogin(String adminCode, String pwd,String sessionCode,String reqCode) {
		if(!sessionCode.equalsIgnoreCase(reqCode)){
			throw new ApplicationException("验证码错误！");
		}
		Admin admin = aDao.findAdminByCode(adminCode);
		if(admin == null){
			  //账号不存在
			  //注：应用异常，指的是因为用户的不正确操作引起的异常，比如账号，密码填写错误
			  //需要明确提示用户采取正确的操作
			 throw new ApplicationException("账号错误！");
		}else if(!pwd.equals(admin.getPassword())){
			throw new ApplicationException("密码错误！");
		}
		//登录成功
		return admin;
	}
      
}
