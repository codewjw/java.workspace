package cn.tedu.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * 用于session验证的拦截器
 */
public class SessionInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse res,
             Object obj) throws Exception {
		   System.out.println("SessionInterceptor.preHandle()");
		   //获取session对象
		   HttpSession session = req.getSession();
		   Object  admin = session.getAttribute("admin");
		   if(admin==null){
			   //没有登录或登录后长时间没操作(session失效)
			   //重定向到登录页面
			   res.sendRedirect("toLogin.do");
			   return false;
		   }
		 //登录过了，记录向后调用
		 return true;
	}
   
}
