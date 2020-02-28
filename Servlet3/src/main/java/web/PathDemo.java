package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathDemo extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
	        //获取访问路径
		    System.out.println(req.getContextPath()); //项目名
		    System.out.println(req.getServletPath()); //Servlet访问路径
		    System.out.println(req.getRequestURI());  //绝对路径
		    System.out.println(req.getRequestURL()); //完整路径
	}
    
}
