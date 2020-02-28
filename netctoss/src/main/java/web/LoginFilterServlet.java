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
		    //ǿת��servlet���õ�����
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            
            //�ų�����Ҫ���˵�����
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
            //��ȡ��¼����
            HttpSession session = request.getSession(); 
            String user = (String) session.getAttribute("user");
            if(user==null){
            	//û��¼���ض��򵽵�¼ҳ��
            	//�˴��þ���·��,�������֪���������ĵ�ַ
            	//�������ָ�������������ĵ�ַ�����ض��򣬼��������ļ�����·�������Բ��������·��
            	String prj_name = request.getContextPath();
            	response.sendRedirect(prj_name+"/toLogin.do");
            }else{
            	//�ѵ�¼���������ִ��
            	chain.doFilter(request, response);
            }
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
