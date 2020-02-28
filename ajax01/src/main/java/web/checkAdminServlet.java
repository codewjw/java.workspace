package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkAdminServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {
		//获取请求路径，再分析请求
	
		String path = req.getServletPath();
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		//对post请求有效，中文转码
	/*	StringBuffer url = req.getRequestURL();
		String uri = req.getRequestURI();
		String pri_path = req.getContextPath();*/
	/*	System.out.println(uri);//绝对路径
		System.out.println(path); //请求路径
		System.out.println(url); //完整路径
		System.out.println(pri_path); //项目路径/ajax01*/
		if("/check.do".equals(path)){
			String adminCode = req.getParameter("adminCode");
			System.out.println(adminCode);
			if("king".equals(adminCode)){
				pw.println("此账号已存在！");
			}else{
				pw.println("此账号符合要求！");
			}
			pw.close();
		 }else if("/checkpwd.do".equals(path)){
			    String pwdCode = req.getParameter("passwd");
				if("123".equals(pwdCode)){
					pw.println("此密码不符合要求！");
				}else{
					pw.println("此密码符合要求！");
				}
				pw.close();
		 }else if("/getNum.do".equals(path)){
			 int num = (int) (Math.random()*1000);
			 pw.println(num);
			 pw.close();
		 }else if("/getFlightPrice.do".equals(path)){
			 String  flight = req.getParameter("flight");
			 if("CA2201".equals(flight)){
				pw.println("头等舱：￥2400<br/>商务舱：￥2200"); 
			 }else{
			    pw.println("头等舱：￥1800<br/>商务舱：￥1600"); 
			 }
		 }
	}

}
