package cn.tedu.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.Result;
import cn.tedu.dao.UserPwdDao;
import cn.tedu.entity.UserPwd;
import cn.tedu.service.UserPwdService;

@Service("userPwdService")
public class UserPwdServiceImpl implements UserPwdService {
	
	@Resource(name="userPwdDao")
	private UserPwdDao updao;
	
	public Result login(String name, String password) {
		UserPwd up = updao.findByName(name);
		Result result = new Result();
		//判断用户是否存在
		if(up==null){
			result.setStatus(0);
		    result.setMsg("用户名不存在");
		}else{
			if(up.getPassword().equals(password)){
				result.setStatus(2);
			    result.setMsg("登录成功！");
			    result.setData(up);
			}else{
				result.setStatus(1);
			    result.setMsg("密码错误！");
			}
		}
		return result;
	}  
}

