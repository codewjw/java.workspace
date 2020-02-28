package cn.tedu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.entity.User;
import cn.tedu.service.UserService;

@Controller
@Scope("prototype")
public class LoginAction {
    private String name;
    private String password;
    
    @Resource
    private UserService userService;
    
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
   
	public String doLogin(){
		User user = userService.login(name, password);
		if(user!=null){
			return "success";
		}
		return "error";
	}
   
}
