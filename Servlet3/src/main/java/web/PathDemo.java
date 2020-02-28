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
	        //��ȡ����·��
		    System.out.println(req.getContextPath()); //��Ŀ��
		    System.out.println(req.getServletPath()); //Servlet����·��
		    System.out.println(req.getRequestURI());  //����·��
		    System.out.println(req.getRequestURL()); //����·��
	}
    
}
