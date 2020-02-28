package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GLFilter implements Filter {

	public void destroy() {
      System.out.println("销毁GLFilter");
	}

	public void doFilter(ServletRequest req, 
			ServletResponse res,
			FilterChain chain)
			throws IOException, ServletException {
		   System.out.println("在前面过滤敏感词");
		   chain.doFilter(req, res);
		   System.out.println("在后面过滤敏感词");
	}

	public void init(FilterConfig cfg) throws ServletException {
       System.out.println("初始化GLFilter");
       String city = cfg.getInitParameter("city");
       System.out.println(city);
	}

}
