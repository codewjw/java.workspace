package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {
   
	private EmpDAO eDao;
	 
	@Before
	/*
	 * @Before修饰的方法会在其他测试方法运行之前先执行
	 */
	public void init(){
		//启动spring容器
		String config = "spring-jdbc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//获取dao对象
	   eDao = ac.getBean("empDAO", EmpDAO.class);
	}
	
	
	//测试jdbc保存
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setName("stven");
		emp.setAge(20);
	    eDao.save(emp);
	}
	
	//测试查询
	@Test
	public void test2(){
		List<Emp> emps = eDao.findAllEmp();
		System.out.println(emps);
	}
	//单个查询
	@Test
	public void test3(){
		Emp emp = eDao.findEmpById(1);
		System.out.println(emp);
	}
	//修改
	@Test
	public void test4(){
		Emp emp = eDao.findEmpById(1);
		if(emp!=null){
			emp.setName("chenwi");
			emp.setAge(30);
		    eDao.modifyEmp(emp);
		}
	}
	
	  //删除
		@Test
		public void test5(){
			    int count = eDao.deleteEmp(1);
			    System.out.println(count);
		}
}
