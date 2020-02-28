package cn.tedu.note.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 对软件业务层进行性能测试
 * @author Administrator
 *
 */
@Component 
@Aspect
public class TimeAspect {
  
	@Around("bean(*Service)")
	public Object test(ProceedingJoinPoint jp)
	throws Throwable{
		long time1 = System.currentTimeMillis();
		Object val = jp.proceed();
		long time2 = System.currentTimeMillis();
		long time = time2 - time1;
		//JoinPoint可以获取目标方法的详细信息：方法签名，调用参数等
		Signature sn = jp.getSignature();
		System.out.println(sn+"用时："+time);
		return val;
		
	}
}
