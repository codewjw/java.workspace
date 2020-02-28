package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;

public class TestDemo {
	
	private SqlSession ss;
	
	//����Mybatis�������ݿ�
	@Before
	public void test(){
		String config = "SqlMapConfig.xml";
		//����SqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//��ȡSqlSessionFactory����
		SqlSessionFactory ssf = ssfb.build(
		TestDemo.class.getClassLoader().
		getResourceAsStream(config));
		//��ȡSqlSession����
	    ss = ssf.openSession();
	}
	
    //�������
	@Test
	public void test1(){
		
		//����SqlSession�����ṩ�ķ����������ݿ�
		Emp emp = new Emp();
		emp.setName("hary");
		emp.setAge(30);
		//���룬��һ����Ϊӳ���ļ�sql���õ�id��
		//testΪsqlӳ���ļ��������ռ䣬saveΪid��ֵ
		ss.insert("test.save", emp);
		//�ύ���ݿ����
		ss.commit();
		//�ر�SqlSession
		ss.close();
	}
	
	//��ѯ����Ա��
	@Test
	public void test2(){
		List<Emp> emps = ss.selectList("test.findAllEmps");
		System.out.println(emps);
		//sqlsession�ײ��黹���ӵ����ӳ�
		ss.close();
	}
	
	   //��ѯ����Ա��
		@Test
		public void test3(){
			Emp emp= ss.selectOne("test.findEmpById",21);
			System.out.println(emp);
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		 //��ѯ����Ա��
		@Test
		public void test4(){
			Emp emp= ss.selectOne("test.findEmpById",21);
			if(emp!=null){
				emp.setName("chenwenjie");
				emp.setAge(emp.getAge()*2);
				ss.update("test.modifyByEmp", emp);
				ss.commit();
			}
			System.out.println(emp);
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		 //��ѯ����Ա��
		@Test
		public void test5(){
		    ss.delete("test.deleteById",21);
			ss.commit();
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		//���Է���Map���͵Ľ��
		@Test
		public void test6(){
			Map data = ss.selectOne("test.findEmpById2", 22);
			System.out.println(data);
			//ע��Oracle���ݿ�Ὣ�ֶ���ͳһ��ɴ�д��ʽ
			System.out.println(data.get("NAME"));
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		//���Է���Map���͵Ľ��
		@Test
		public void test7(){
			Employee emp = ss.selectOne("test.findEmpById3", 22);
			System.out.println(emp);
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
}
