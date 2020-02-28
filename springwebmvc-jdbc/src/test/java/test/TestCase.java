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
	 * @Before���εķ��������������Է�������֮ǰ��ִ��
	 */
	public void init(){
		//����spring����
		String config = "spring-jdbc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		//��ȡdao����
	   eDao = ac.getBean("empDAO", EmpDAO.class);
	}
	
	
	//����jdbc����
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setName("stven");
		emp.setAge(20);
	    eDao.save(emp);
	}
	
	//���Բ�ѯ
	@Test
	public void test2(){
		List<Emp> emps = eDao.findAllEmp();
		System.out.println(emps);
	}
	//������ѯ
	@Test
	public void test3(){
		Emp emp = eDao.findEmpById(1);
		System.out.println(emp);
	}
	//�޸�
	@Test
	public void test4(){
		Emp emp = eDao.findEmpById(1);
		if(emp!=null){
			emp.setName("chenwi");
			emp.setAge(30);
		    eDao.modifyEmp(emp);
		}
	}
	
	  //ɾ��
		@Test
		public void test5(){
			    int count = eDao.deleteEmp(1);
			    System.out.println(count);
		}
}
