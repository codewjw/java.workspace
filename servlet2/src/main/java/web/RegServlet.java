package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//处理请求的一般流程：
		//只对post有效
		request.setCharacterEncoding("utf-8"); 
		//1.接收业务
		 String username = request.getParameter("username");
		 String pwd = request.getParameter("passwd");
		 String sex = request.getParameter("sex");
		 String[] interests = request.getParameterValues("interest");
		 
		 //解决乱码的方法1,对post和get都管用，但是比较麻烦，一般不用
		/* byte[] bs = username.getBytes("iso8859-1");
		 username = new String(bs,"utf-8");*/
		 
		 //2.处理业务
		 System.out.println(username);
		 System.out.println(pwd);
		 System.out.println(sex);
		 for(String inter:interests){
			 System.out.println(inter);
		 }
	    
		//3.发送响应,响应乱码问题
		response.setContentType("text/html;charset=utf-8");
		//响应的编码乱码问题
		//response.setCharacterEncoding("utf-8");
	    PrintWriter pw =response.getWriter();
	    pw.println("<p>ok!"+username+"</p>");
	    pw.close();
	}
   
}
