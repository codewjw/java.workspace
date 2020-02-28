package test;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest {

	protected ClassPathXmlApplicationContext cpxac;

	@Before
	public void beforeTest() {
		cpxac = new ClassPathXmlApplicationContext(
				"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml",
				"conf/spring-service.xml");
	}

	@After
	public void afterTest() {
		cpxac.close();
	}

}