package test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAOMyBatis;
import entity.Emp;

public class TestCase {
  
	@Test 
	public void test1(){
		String config = "mybatis-spring.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//用MapperScannerConfigurer配置扫描过dao包，没有配置bean的名称，就用默认名称
		//即接口名首字母小写
		//EmpDAOMyBatis dao = new EmpDAOMyBatis();
		EmpDAOMyBatis dao = ac.getBean("empDao",EmpDAOMyBatis.class);
	    List<Emp> emps = dao.findAllEmps();
	    System.out.println(emps);
	}
}
