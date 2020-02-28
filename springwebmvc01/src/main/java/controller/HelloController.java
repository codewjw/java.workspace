package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{
  
	 public ModelAndView handleRequest(
			 HttpServletRequest req,
			 HttpServletResponse res) throws Exception{
		 System.out.println("handleRequest()");
		 /*
		  * ModelAndiew有两个常用构造器
		  * ModelAndView(String viewName)
		  * ModelAndView(String viewName,Map data)
		  * 注：viewName：视图名
		  * data:处理结果
		  */
		 return new ModelAndView("hello");//hello就是视图名，即jsp的名字
	 }
	 
}
