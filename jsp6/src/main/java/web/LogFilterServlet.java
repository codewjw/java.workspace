package web;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class LogFilterServlet implements Filter{

	public void destroy() {
	    //tomcat服务器关闭时销毁
		System.out.println("销毁LogFilter");
	}

	//处理公共业务
	public void doFilter(ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		    System.out.println("在前面记日志");
		    chain.doFilter(request, response);
		    System.out.println("在后面记日志");
	}

	public void init(FilterConfig arg0) throws ServletException {
		//tomcat服务器启动时就初始化
		System.out.println("初始化LogFilter");
	}

}
