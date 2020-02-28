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
		  * ModelAndiew���������ù�����
		  * ModelAndView(String viewName)
		  * ModelAndView(String viewName,Map data)
		  * ע��viewName����ͼ��
		  * data:������
		  */
		 return new ModelAndView("hello");//hello������ͼ������jsp������
	 }
	 
}
