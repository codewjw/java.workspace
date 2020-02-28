package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	//Tomcat创建Servlet的过程:
	//LoginServlet ls = new LoginServlet();
	//ServletConfig cfg = new ServletConfig();
	//ls.init(cfg); //有参数的init里面会调用无参的init
	//ls.service();
	
	@Override
	protected void service(HttpServletRequest 
			req, HttpServletResponse res) 
					throws ServletException, IOException {
		//读取config配置数据
		ServletConfig cfg = getServletConfig();
		String maxOnline = cfg.getInitParameter("maxOnline");
		System.out.println(maxOnline);
	}

	
}
