package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointcutAspect {
   
	//@Before("bean(*Service)") //bean切入点
	//@Before("within(cn.tedu.note.*.*ServiceImpl)") //类切入点
	//@Before("execution(* cn.tedu.note.service.UserService.Login(..))") //方法名切入点
	/*@Before("execution(* cn.tedu.note.*.*Service.list*(..))")
	public void test(){
		System.out.println("切入点测试");
	}*/
}
