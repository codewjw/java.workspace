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
   
	//测试连接池
	@Test
	public void test1() throws SQLException{
		String config = "spring-mvc.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		/*
		 * DataSource 是一个接口，BasicDataSource是一个实现了该接口的具体类
		 */
		DataSource ds = ac.getBean("datasource", DataSource.class);
		System.out.println(ds);
		System.out.println(ds.getConnection());
	}
	
	   //测试持久层
		@Test
		public void test2() throws SQLException{
			String config = "spring-mvc.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			/*
			 * DataSource 是一个接口，BasicDataSource是一个实现了该接口的具体类
			 */
			 AdminDaoJdbcImpl aDao = ac.getBean("adminDAO", AdminDaoJdbcImpl.class);
			 Admin admin = aDao.findAdminByCode("admin");
		
			System.out.println(admin);
		}
		
		//测试业务层
		@Test
		public void test3(){
			String config = "spring-mvc.xml";
			ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			LoginService service = ac.getBean("loginService",LoginService.class);
			Admin admin = service.checkLogin("caocao", "123","1","1");
			System.out.println(admin);
		}
}
