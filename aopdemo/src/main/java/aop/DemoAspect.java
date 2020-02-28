package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * 创建一个切面组件，就是一个普通的javaBean
 */

@Component
@Aspect
public class DemoAspect {
   
	//声明test方法将在userService的全部方法执行之前运行
   @Before("bean(userService)")
   public void hello(){
	   System.out.println("hello world!");
   }
}
