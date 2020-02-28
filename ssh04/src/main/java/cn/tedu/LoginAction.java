package cn.tedu;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.UserPwd;
import cn.tedu.service.UserPwdService;

@Controller
@Scope("prototype")
public class LoginAction implements SessionAware{
    private String name;
    private String password;
    private Map<String,Object> session;
    private Result result;
    
    @Resource(name="userPwdService")
    private UserPwdService userPwdService;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	
	public String login(){
		Result result = userPwdService.login(name, password);
		this.result = result;
		if(result.getStatus()==2){
			UserPwd up = (UserPwd) result.getData();
			session.put("userpwd", up);
		}else {
			//UserPwd up = (UserPwd) result.getData();
			return "error";
		}
		return "success";
	}
   
}
