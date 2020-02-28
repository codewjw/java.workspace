package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{

	/*
	 * ���ִ��
	 * ���� e��Controller���׳����쳣
	 */
	public void afterCompletion(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj, 
			Exception e)
			throws Exception {
		System.out.println("afterCompletion()");
	}
    
	/*
	 * Controller�ķ����Ѿ�ִ����ϣ���׼����ModelAndView
	 * ���ظ�DispatcherServlet֮ǰ��ִ��postHandle������
	 * �����ڸ����棬�޸Ĵ�����(ModelAndView)
	 * 
	 * ��������ǰ�˿�����(DispatcherServlet)�����������(HttpServletRequest)
	 * ����Ӧ����(HttpServletResponse)
	 */
	public void postHandle(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj,
			ModelAndView mav)
			throws Exception {
		System.out.println("postHandle()");
		
	}
    
	/*
	 * DispatcherServlet(ǰ�˿�����)���յ�����֮��
	 * ���ȵ���preHandle������
	 * ����÷�������ֵ��true������������ã������ж�����
	 * ע��
	 * ��������ǰ�˿�����(DispatcherServlet)�����������(HttpServletRequest)
	 * ����Ӧ����(HttpServletResponse)
	 * ����obj��Controller�ķ�������
	 */
	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj) throws Exception {
		System.out.println("preHandle(req,res,obj)");
		return true;
	}

}
