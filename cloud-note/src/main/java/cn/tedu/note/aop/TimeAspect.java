package cn.tedu.note.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * �����ҵ���������ܲ���
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
		//JoinPoint���Ի�ȡĿ�귽������ϸ��Ϣ������ǩ�������ò�����
		Signature sn = jp.getSignature();
		System.out.println(sn+"��ʱ��"+time);
		return val;
		
	}
}
