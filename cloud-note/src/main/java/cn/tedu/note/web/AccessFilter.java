package cn.tedu.note.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.note.entity.User;

/**
 * Servlet Filter implementation class AccessFilter
 */
public class AccessFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AccessFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 String login="/log_in.html";
		 HttpServletRequest req = (HttpServletRequest) request;
		 HttpServletResponse res = (HttpServletResponse) response;
		 String path = req.getRequestURI();
		//放过log_in.html，检查登录
		 if(path.endsWith(login)){
			 chain.doFilter(request, response);
			 return;
		 }
		 if(path.endsWith("alert_error.html")||path.endsWith("demo.html")){
			 chain.doFilter(request, response);
			 return;
		 }
		//如果没有登录就重定向到登录页面，登录了就放过
		User user = (User) req.getSession().getAttribute("user") ;
		if(user == null){
			//重定向到登录页面,重定向最好用绝对路径
			res.sendRedirect(req.getContextPath()+login);
			return;
		}
		chain.doFilter(request, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {}

}
