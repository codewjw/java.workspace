package test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.MessageService;
import basic.Teacher;

public class TestCase {

	@Test
	public void test1(){
		String config = "basic.xml";
		/*
    	 * ApplicationContext是接口
    	 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径
    	 * 取查找spring配置文件，然后启动spring容器
    	 */
		//启动Spring容器,默认情况下,容器会将config文件中包含的bean(作用域为单例的bean)对应的对象创建好
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Teacher teac1 = ac.getBean("teac1",Teacher.class);
		Teacher teac2 = ac.getBean("teac1",Teacher.class);
		//singleton:默认情况，true:说明只创建一个对象，所以两个引用所存的地址相同
		//prototype：则以下结果为false，说明创建两个对象
		System.out.println(teac1==teac2);
	}
	
	@Test
	public void test2(){
		String config = "basic.xml";
		/*
    	 * ApplicationContext是接口
    	 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径
    	 * 取查找spring配置文件，然后启动spring容器
    	 */
		//启动Spring容器,默认情况下,容器会将config文件中包含的bean(作用域为单例的bean)对应的对象创建好
		/*
		 * ApplicationContext中并没有提供关闭容器的方法(close())
		 * 需要用其子接口
		 */
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(config);
        MessageService ms = ac.getBean("msg1",MessageService.class);
        
        //关闭容器
        ac.close();
	}
	
	@Test
	public void test3(){
		String config = "applicationContext.xml";
		/*
    	 * ApplicationContext是接口
    	 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径
    	 * 取查找spring配置文件，然后启动spring容器
    	 */
		//启动Spring容器,默认情况下,容器会将config文件中包含的bean(作用域为单例的bean)对应的对象创建好
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		//singleton:默认情况，true:说明只创建一个对象，所以两个引用所存的地址相同
		//prototype：则以下结果为false，说明创建两个对象
		System.out.println(cal1);
	}
	
	@Test
	public void test4(){
		String config = "applicationContext.xml";
		/*
    	 * ApplicationContext是接口
    	 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径
    	 * 取查找spring配置文件，然后启动spring容器
    	 */
		//启动Spring容器,默认情况下,容器会将config文件中包含的bean(作用域为单例的bean)对应的对象创建好
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Date time1 = ac.getBean("time1",Date.class);
		//singleton:默认情况，true:说明只创建一个对象，所以两个引用所存的地址相同
		//prototype：则以下结果为false，说明创建两个对象
		System.out.println(time1);
	}
}
