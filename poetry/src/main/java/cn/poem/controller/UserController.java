package cn.poem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.poem.entity.User;
import cn.poem.exception.AbstructHandleException;
import cn.poem.exception.PassWordNotFoundException;
import cn.poem.exception.UserNotFoundException;
import cn.poem.result.JsonResult;
import cn.poem.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends AbstructHandleException{
   
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public JsonResult  regist(String name,String password,String confirmPsw,
			String nick,String email){
		Integer num = userService.regist(name, password, confirmPsw, nick, email);
		return new JsonResult(num.toString());
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public JsonResult login(String name,String password){
		User user = userService.login(name, password);
		return new JsonResult(user);
	}
	
	@RequestMapping("/main.do")
	public String toMain(){
		return "mainpoem";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public JsonResult HandleUserNotFoundException(UserNotFoundException e){
		return new JsonResult(2,e);
	}
	
	@ExceptionHandler(PassWordNotFoundException.class)
	@ResponseBody
	public JsonResult HandlePasswordNotFoundException(PassWordNotFoundException e){
		return new JsonResult(3,e);
	}
	
}
