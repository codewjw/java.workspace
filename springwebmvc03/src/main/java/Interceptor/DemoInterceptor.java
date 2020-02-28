package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class DemoInterceptor implements HandlerInterceptor{

	/*
	 * 最后执行
	 * 参数 e是Controller所抛出的异常
	 */
	public void afterCompletion(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj, 
			Exception e)
			throws Exception {
		System.out.println("afterCompletion()");
	}
    
	/*
	 * Controller的方法已经执行完毕，正准备将ModelAndView
	 * 返回给DispatcherServlet之前，执行postHandle方法，
	 * 可以在该里面，修改处理解过(ModelAndView)
	 * 
	 * 拦截器跟前端控制器(DispatcherServlet)共享请求对象(HttpServletRequest)
	 * 和响应对象(HttpServletResponse)
	 */
	public void postHandle(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj,
			ModelAndView mav)
			throws Exception {
		System.out.println("postHandle()");
		
	}
    
	/*
	 * DispatcherServlet(前端控制器)在收到请求之后，
	 * 会先调用preHandle方法，
	 * 如果该方法返回值是true，则继续向后调用，否则，中断请求
	 * 注：
	 * 拦截器跟前端控制器(DispatcherServlet)共享请求对象(HttpServletRequest)
	 * 和响应对象(HttpServletResponse)
	 * 参数obj是Controller的方法对象
	 */
	public boolean preHandle(HttpServletRequest req, 
			HttpServletResponse res,
			Object obj) throws Exception {
		System.out.println("preHandle(req,res,obj)");
		return true;
	}

}
