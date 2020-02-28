package cn.tedu.netctoss.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.ApplicationException;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.util.ImageUtil;

@Controller
public class LoginServletController {
	  @Resource(name="loginService")
      private  LoginService ls;
	  
	  //spring框架处理异常
	  @ExceptionHandler
	  public String handlerEx(Exception e,HttpServletRequest req){
		   //e.printStackTrace();
		   if(e instanceof ApplicationException){
			   //应用异常要明确提示用户
			   /*
			    * getMessage()方法继承自RuntimeException方法
			    * 作用是获取异常描述信息
			    */
			   req.setAttribute("error", e.getMessage());
			   return "login";
		   }
		   //系统异常，提示用户稍后重试
			return "error";
	  }
	  
	   @RequestMapping("toLogin.do")
	   public String toLogin(){
		   System.out.println("toLogin()");
		   return "login";
	   }
	   
	   @RequestMapping("login.do")
	   public String Login(HttpServletRequest req,HttpSession session){ 
		   String adminCode = req.getParameter("adminCode");
		   String pwd = req.getParameter("passwd");
		   //获取验证码
		   String sessionCode = (String) session.getAttribute("checkcode");
		   String reqCode = req.getParameter("imgcode");
		   Admin admin = null;
		   admin = ls.checkLogin(adminCode, pwd,sessionCode,reqCode);
		   //登录成功，将管理员对象绑定到session对象上面
		   session.setAttribute("admin", admin);
		return "redirect:toIndex.do";
		   
	   }
	   
	   @RequestMapping("toIndex.do")
	   public String toIndex(){
		   return "index";
	   }
	   
	   //返回验证码图片
	   @RequestMapping("/createImg.do")
	   public void checkcode(HttpServletResponse res,
			   HttpSession session) throws IOException{
		   Object[] objs = ImageUtil.createImage();
		   //获取验证码图片
		   BufferedImage img =  (BufferedImage) objs[1];
		   //将验证码的值放入session中
		   session.setAttribute("checkcode", objs[0]);
		   //将验证码图片发送给浏览器
		   //图片传输是字节输出流，所以不能用字符输出流对象PrintWriter
		   OutputStream os = res.getOutputStream();
		   /*
		    * 参数1为图片对象
		    * 参数2为图片输出格式
		    * 参数3指定字节输出流
		    */
		   javax.imageio.ImageIO.write(img,"jpeg",os);
		   os.close();
	   }
}
