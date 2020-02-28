package cn.tedu;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DemoInterceptor implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截开始");
		invocation.invoke();//放行，调用Action
		System.out.println("结束拦截");
		return null;
	}

}
