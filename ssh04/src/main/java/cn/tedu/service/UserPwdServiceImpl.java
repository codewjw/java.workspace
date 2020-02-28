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
		//�ж��û��Ƿ����
		if(up==null){
			result.setStatus(0);
		    result.setMsg("�û���������");
		}else{
			if(up.getPassword().equals(password)){
				result.setStatus(2);
			    result.setMsg("��¼�ɹ���");
			    result.setData(up);
			}else{
				result.setStatus(1);
			    result.setMsg("�������");
			}
		}
		return result;
	}  
}

