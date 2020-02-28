package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res) 
					throws ServletException, IOException {
		//浏览器在访问服务器时，它会自动传入它之前保存的cookie
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			res.setContentType("text/html;charset=utf-8");
			PrintWriter pw = res.getWriter();
			for(Cookie cook:cookies){
				if(cook.getName().equals("city")){
					String value = URLDecoder.decode(cook.getValue(),"utf-8");
				    pw.println(cook.getName()+","+value);
				}else{
					 pw.println(cook.getName()+","+cook.getValue());
				}
			}
			pw.close();
		}
		
		}
  
	
	
}
