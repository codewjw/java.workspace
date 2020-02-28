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
		//�Ź�log_in.html������¼
		 if(path.endsWith(login)){
			 chain.doFilter(request, response);
			 return;
		 }
		 if(path.endsWith("alert_error.html")||path.endsWith("demo.html")){
			 chain.doFilter(request, response);
			 return;
		 }
		//���û�е�¼���ض��򵽵�¼ҳ�棬��¼�˾ͷŹ�
		User user = (User) req.getSession().getAttribute("user") ;
		if(user == null){
			//�ض��򵽵�¼ҳ��,�ض�������þ���·��
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
