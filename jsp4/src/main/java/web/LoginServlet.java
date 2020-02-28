package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String path = req.getServletPath();
		String user = req.getParameter("user");
	    //将账号存入cookie,一个cookie对象当中只能存一条数据，并且只能存字符串
		Cookie cook = new Cookie("user",user);
		//将cookie存到硬盘上
		cook.setMaxAge(60*30);
		//将cookie发送给浏览器,将cookie绑定到response上,
		//当服务器发送响应时会自动发送cookie,浏览器会保存
		res.addCookie(cook);
		
		//发送中文
		Cookie cook2 = new Cookie("city",
				URLEncoder.encode("北京","utf-8"));
		res.addCookie(cook2);
		
		//设定cookie的有效路径
		Cookie cook3 = new Cookie("status","1");
		//设定cookie有效路径为整个项目
		cook3.setPath("/jsp4");
		res.addCookie(cook3);
	}
    
}
