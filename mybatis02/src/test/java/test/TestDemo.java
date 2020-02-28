package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;
import entity.Employee;


public class TestDemo {
	
	private SqlSession ss;
	
	@Before
	public void test(){
		String config = "SqlMapConfig.xml";
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(
				TestDemo.class.getClassLoader()
				.getResourceAsStream(config));
		 ss = ssf.openSession();
	}
	
	@Test
	public void test1(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		Emp emp = new Emp();
		emp.setName("����ʿ");
		emp.setAge(30);
		ed.save(emp);
		ss.commit();
		ss.close();
	}
	@Test
	public void test2(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		List<Emp> emps=ed.findAllEmps();
		System.out.println(emps);
		ss.close();
	}
	
	@Test
	public void test3(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		Emp emp=ed.findEmpById(23);
		System.out.println(emp);
		ss.close();
	}
	
	@Test
	public void test4(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		Emp emp = ed.findEmpById(23);
		if(emp!=null){
			emp.setName("��׳ʿ");
			emp.setAge(36);
		    ed.modifyByEmp(emp);
		    ss.commit();
		}
		System.out.println(emp);
		ss.close();
	}
	@Test
	public void test5(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		ed.deleteById(23);
		//��Ҫ�ύ����
		ss.commit();
		//�ر�SqlSessionӦ��д��finally��
		ss.close();
	}
	
	@Test
	public void test6(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		Map map = ed.findEmpById2(22);
	    System.out.println(map.get("NAME"));
		ss.close();
	}
	
	@Test
	public void test7(){
		//MyBatis�᷵�ط���Mapperӳ����Ҫ��Ķ���
		EmpDAO ed = ss.getMapper(EmpDAO.class);
		Employee emp = ed.findEmpById3(22);
	    System.out.println(emp);
		ss.close();
	}
	
}
