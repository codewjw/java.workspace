package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.Teacher;

public class TeacherTest {
	
	private Configuration cfg;

	@Before
	public void beforeTest(){
		cfg = new Configuration();
	}
	
	@Test
	public void test1(){
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher teacher = new Teacher();
		teacher.setUsername("huang");
		System.out.println(teacher);
		session.save(teacher);
		System.out.println(teacher);
		tran.commit();
		session.close();
	}
}
