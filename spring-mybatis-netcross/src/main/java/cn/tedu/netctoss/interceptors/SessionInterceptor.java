package cn.tedu.netctoss.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * ����session��֤��������
 */
public class SessionInterceptor implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse res,
             Object obj) throws Exception {
		   System.out.println("SessionInterceptor.preHandle()");
		   //��ȡsession����
		   HttpSession session = req.getSession();
		   Object  admin = session.getAttribute("admin");
		   if(admin==null){
			   //û�е�¼���¼��ʱ��û����(sessionʧЧ)
			   //�ض��򵽵�¼ҳ��
			   res.sendRedirect("toLogin.do");
			   return false;
		   }
		 //��¼���ˣ���¼������
		 return true;
	}
   
}
