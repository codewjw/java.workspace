package cn.tedu;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;


public class Login2Action implements SessionAware{

	private User user;
	private String message;
	private Map<String,Object> session;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String doLogin2(){
		/**
		 * 工厂方法获取session对象
		*ActionContext ctx = ActionContext.getContext();
		*Map<String,Object> session = ctx.getSession();
		*/
		System.out.println("Login2Action.doLogin2()"+user.getUsername()+","+user.getPassword());
		if(user.getUsername().equals("Tom")&&user.getPassword().equals("111111")){
			session.put("loginName", user.getUsername());
			return "success";
		}
		message = "用户名或密码出错，请重新登录";
		return "error";
	}
}
