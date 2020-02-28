package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
  
	@Test 
	public void test1(){
		String config = "mybatis-spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//��MapperScannerConfigurer����ɨ���dao����û������bean�����ƣ�����Ĭ������
		//���ӿ�������ĸСд
		//EmpDAO dao = ac.getBean("empDAO",EmpDAO.class);
		EmpDAO dao = ac.getBean("edao",EmpDAO.class);
	    List<Emp> emps = dao.findAllEmps();
	    System.out.println(emps);
	}
}
