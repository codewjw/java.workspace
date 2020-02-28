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
	
	   //����test1��������userService��ȫ������ִ��֮ǰ����
	 /*  @Before("bean(userService)")
	   public void test1(){
		   System.out.println("before hello world!");
	   }*/
	   
	   //����test��������userService��ȫ������ִ��֮������
	   /*@After("bean(userService)")
	   public void test2(){
		   System.out.println("after hello world!");
	   }
	   */
	   //����test��������userService��ȫ������ִ��֮������
	 /*  @AfterReturning("bean(userService)")
	   public void test3(){
		   System.out.println("AfterReturning hello world!");
	   }*/
	   
	   //����test��������userService��ȫ������ִ��֮������
	  /* @AfterThrowing("bean(userService)")
	   public void test4(){
		   System.out.println("AfterThrowing hello world!");
	   }*/
	   
	   /**
	    * 
	    * ����֪ͨ����
	    * 1.�����з���ֵ
	    * 2.�����в��� ProceedingJoinPoint jp
	    * 3.�����׳��쳣
	    * 4.��Ҫ�ڷ����е��� jp.proceed();
	    * 5.����ҵ�񷽷��ķ���ֵ
	    * @param jp
	    * @return
	    * @throws Throwable
	    */
	  /* @Around("bean(userService)")
	   public Object test5(ProceedingJoinPoint jp) throws Throwable{
		Object val = jp.proceed();
		System.out.println("ҵ����:"+val);
		//throw new UserNotFoundException("���ǲ������¼");
		return val;
	   }*/
}
