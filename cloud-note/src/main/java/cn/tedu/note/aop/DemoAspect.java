package cn.tedu.note.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.tedu.note.service.UserNotFoundException;


@Component
@Aspect
public class DemoAspect {
	
	   //声明test1方法将在userService的全部方法执行之前运行
	 /*  @Before("bean(userService)")
	   public void test1(){
		   System.out.println("before hello world!");
	   }*/
	   
	   //声明test方法将在userService的全部方法执行之后运行
	   /*@After("bean(userService)")
	   public void test2(){
		   System.out.println("after hello world!");
	   }
	   */
	   //声明test方法将在userService的全部方法执行之后运行
	 /*  @AfterReturning("bean(userService)")
	   public void test3(){
		   System.out.println("AfterReturning hello world!");
	   }*/
	   
	   //声明test方法将在userService的全部方法执行之后运行
	  /* @AfterThrowing("bean(userService)")
	   public void test4(){
		   System.out.println("AfterThrowing hello world!");
	   }*/
	   
	   /**
	    * 
	    * 环绕通知方法
	    * 1.必须有返回值
	    * 2.必须有参数 ProceedingJoinPoint jp
	    * 3.必须抛出异常
	    * 4.需要在方法中调用 jp.proceed();
	    * 5.返回业务方法的返回值
	    * @param jp
	    * @return
	    * @throws Throwable
	    */
	  /* @Around("bean(userService)")
	   public Object test5(ProceedingJoinPoint jp) throws Throwable{
		Object val = jp.proceed();
		System.out.println("业务结果:"+val);
		//throw new UserNotFoundException("就是不让你登录");
		return val;
	   }*/
}
