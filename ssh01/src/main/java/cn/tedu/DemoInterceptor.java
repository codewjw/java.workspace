package cn.tedu;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DemoInterceptor implements Interceptor{

	private static final long serialVersionUID = -7319287594856487248L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation in) throws Exception {
		System.out.println("拦截开始");
		in.invoke();//放行，调用Action
		System.out.println("结束拦截");
		return null;
	}

}
