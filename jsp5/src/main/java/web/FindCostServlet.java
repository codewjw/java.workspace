package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FindCostServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) 
					throws ServletException, IOException {
		 //本次请求中，浏览器会自动传入保存的JSESSIONID,然后服务器根据此ID找到旧的session
		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("user");
		//移除session属性
		//session.removeAttribute("user");
		//销毁session
		//session.invalidate();
		res.setContentType("text/html;charset=utf-8");
	    PrintWriter pw = res.getWriter();
	    pw.println("<p>"+user+"</p>");
	    pw.close();
  }

}
