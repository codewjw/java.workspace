package cn.tedu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.Book;

public class BookTest {
  
	private Session session;
	
	@Before
	public void beforeTest(){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}
	
	@Test 
	public void test1(){
		//��������
		Transaction tran = session.beginTransaction();
		//��������
		tran.begin();
		Book book = (Book) session.get(Book.class, 1);
		System.out.println(book);
		tran.commit();
		session.close();
	}
}
