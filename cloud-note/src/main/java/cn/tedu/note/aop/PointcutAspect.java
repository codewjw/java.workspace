package cn.tedu.note.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PointcutAspect {
   
	//@Before("bean(*Service)") //bean�����
	//@Before("within(cn.tedu.note.*.*ServiceImpl)") //�������
	//@Before("execution(* cn.tedu.note.service.UserService.Login(..))") //�����������
	/*@Before("execution(* cn.tedu.note.*.*Service.list*(..))")
	public void test(){
		System.out.println("��������");
	}*/
}
