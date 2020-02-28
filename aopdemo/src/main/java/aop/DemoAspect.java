package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * ����һ���������������һ����ͨ��javaBean
 */

@Component
@Aspect
public class DemoAspect {
   
	//����test��������userService��ȫ������ִ��֮ǰ����
   @Before("bean(userService)")
   public void hello(){
	   System.out.println("hello world!");
   }
}
