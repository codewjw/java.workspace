package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCostServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
	     Cookie[] cookies = req.getCookies();
	     if(cookies!=null){
	    	 res.setContentType("text/html;charset=utf-8");
	    	 PrintWriter pw = res.getWriter();
	    	 for(Cookie ck:cookies){
	    		 pw.println(ck.getName()+":"+
	    	   URLDecoder.decode(ck.getValue(),"utf-8"));
	    	 }
	    	 pw.close();
	     }
	}
    
}
