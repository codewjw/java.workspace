package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {
		 String user = req.getParameter("user");
		 //首次调用session时服务器会自动给当前访问的浏览器创建一个session
		 //该session就是jsp隐含对象之一
		 HttpSession session = req.getSession();
		 //session中可以存任意类型的数据，cookie只能存字符串
		 session.setAttribute("user", user);
		 
		 //服务器响应时会作出如下处理,会将创建的cookie加到response
		//随着response发送给浏览器保存,并且将cookie路径设置为项目路径
		 //以便整个项目都可以用这个cookie
		 //Cookie c = new Cookie("JSESSIONID",session.getId());
		 //c.setPath(request.getContextPath());
		
	}
 
}
