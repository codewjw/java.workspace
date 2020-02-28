package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage_1_0;

public class LoginFilterServlet implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest req, 
			ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		    //强转成servlet常用的类型
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            
            //排除不需要过滤的请求
            String[] paths = new String[]{
            		"/toLogin.do",
            		"/login.do",
            		"/createImg.do"
            };
            String currentPath = request.getServletPath();
            for(String path:paths){
            	if(path.equals(currentPath)){
            		chain.doFilter(request, response);
            		return;
            	}
            }
            //获取登录名字
            HttpSession session = request.getSession(); 
            String user = (String) session.getAttribute("user");
            if(user==null){
            	//没登录，重定向到登录页面
            	//此处用绝对路径,浏览器不知道过滤器的地址
            	//服务器又根据浏览器传过的地址进行重定向，即过滤器文件所在路径，所以不能用相对路径
            	String prj_name = request.getContextPath();
            	response.sendRedirect(prj_name+"/toLogin.do");
            }else{
            	//已登录，请求继续执行
            	chain.doFilter(request, response);
            }
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
