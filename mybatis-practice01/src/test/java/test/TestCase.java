package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Dept;

public class TestCase {
private SqlSession ss;
	
	//����Mybatis�������ݿ�
	@Before
	public void test(){
		String config = "SqlMapConfig.xml";
		//����SqlSessionFactoryBuilder����
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//��ȡSqlSessionFactory����
		SqlSessionFactory ssf = ssfb.build(
		TestCase.class.getClassLoader().
		getResourceAsStream(config));
		//��ȡSqlSession����
	    ss = ssf.openSession();
	}
	
    //�������
	@Test
	public void test1(){
		
		//����SqlSession�����ṩ�ķ����������ݿ�
		Dept dept = new Dept();
		dept.setDeptName("��Ʋ�");
		dept.setAddress("���뻨԰02��");
		//���룬��һ����Ϊӳ���ļ�sql���õ�id��
		//testΪsqlӳ���ļ��������ռ䣬saveΪid��ֵ
		ss.insert("practice.save", dept);
		//�ύ���ݿ����
		ss.commit();
		//�ر�SqlSession
		ss.close();
	}
	
	//��ѯ����Ա��
	@Test
	public void test2(){
		List<Dept> depts = ss.selectList("practice.findAllDepts");
		System.out.println(depts);
		//sqlsession�ײ��黹���ӵ����ӳ�
		ss.close();
	}
	
	   //��ѯ����Ա��
		@Test
		public void test3(){
			Dept dept= ss.selectOne("practice.findDeptById",1);
			System.out.println(dept);
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		 //��ѯ����Ա��
		@Test
		public void test4(){
			Dept dept= ss.selectOne("practice.findDeptById",1);
			if(dept!=null){
				dept.setDeptName("�ʲ�����");
				dept.setAddress("���·һ��");
				ss.update("practice.modifyByDept", dept);
				ss.commit();
			}
			System.out.println(dept);
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
		
		 //��ѯ����Ա��
		@Test
		public void test5(){
		    ss.delete("practice.deleteById",1);
			ss.commit();
			//sqlsession�ײ��黹���ӵ����ӳ�
			ss.close();
		}
}
