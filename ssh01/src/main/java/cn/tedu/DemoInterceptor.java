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
		System.out.println("���ؿ�ʼ");
		in.invoke();//���У�����Action
		System.out.println("��������");
		return null;
	}

}
