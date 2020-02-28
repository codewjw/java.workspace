package test;



import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.netctoss.dao.AdminDaoJdbcImpl;
import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.service.LoginServiceImpl;

public class TestDemo {
   
	//�������ӳ�
	@Test
	public void test1() throws SQLException{
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		/*
		 * DataSource ��һ���ӿڣ�BasicDataSource��һ��ʵ���˸ýӿڵľ�����
		 */
		DataSource ds = ac.getBean("datasource", DataSource.class);
		System.out.println(ds);
		System.out.println(ds.getConnection());
	}
	
	   //���Գ־ò�
		@Test
		public void test2() throws SQLException{
			String config = "spring-mvc.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			/*
			 * DataSource ��һ���ӿڣ�BasicDataSource��һ��ʵ���˸ýӿڵľ�����
			 */
			 AdminDaoJdbcImpl aDao = ac.getBean("adminDAO", AdminDaoJdbcImpl.class);
			 Admin admin = aDao.findAdminByCode("admin");
		
			System.out.println(admin);
		}
		
		//����ҵ���
		@Test
		public void test3(){
			String config = "spring-mvc.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			LoginService service = ac.getBean("loginService",LoginService.class);
			Admin admin = service.checkLogin("caocao", "123","1","1");
			System.out.println(admin);
		}
}
