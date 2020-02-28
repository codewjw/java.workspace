package test;



import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import autowire.Boo;
import ioc.A;
import ioc.Manager;
import ioc.Restaurant;
import value.DemoBean;
import value.ExampleBean;
import value.InfoBean;
import value.ValueBean;

public class TestDemo {
	 
	//测试set方法注入
	 @Test
	  public void test1(){
		  String config = "ioc.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		  A a = ac.getBean("a1",A.class);
		  a.execute();
	  }
	 
	//测试set方法注入
	 @Test
	  public void test2(){
		  String config = "ioc.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		  Restaurant r = ac.getBean("r1",Restaurant.class);
		  r.execute();
	  }
	 
	 //测试构造器注入
	 @Test
	  public void test3(){
		  String config = "ioc.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		  Manager m1 = ac.getBean("m1",Manager.class);
		 System.out.println(m1);
	  }
	 
	 //测试自动装配
	 @Test
	  public void test4(){
		  String config = "autowire.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		  Boo boo = ac.getBean("boo",Boo.class);
		 System.out.println(boo);
	  }
	 
	 //构造器注入
	 @Test
	  public void test5(){
		  String config = "test.xml";
		  ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		  Car car = ac.getBean("c1",Car.class);
		 System.out.println(car);
	  }
	 
	 //注入基本类型数据的值即直接注入集合类型的值，用set方法注入
	 @Test
	 public void test6(){
		 String config = "value.xml";
		 ApplicationContext ac = new ClassPathXmlApplicationContext(config);
		 ValueBean vb = ac.getBean("vb1", ValueBean.class);
		 System.out.println(vb);
	 }
	 
	     //引用注入集合类型的值，用set方法注入
		 @Test
		 public void test7(){
			 String config = "value.xml";
			 ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			 ExampleBean eb = ac.getBean("eb1", ExampleBean.class);
			 System.out.println(eb);
		 }
		 
       //读取.properties文件的内容
		 @Test
		 public void test8(){
			 String config = "value.xml";
			 ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			 Properties prop = ac.getBean("config", Properties.class);
			 System.out.println(prop);
		 }
		 
	    //练习
		 @Test
		 public void test9(){
			 String config = "demo.xml";
			 ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			 DemoBean db = ac.getBean("db1", DemoBean.class);
			 System.out.println(db);
		 }
		 
		//spring表达式
		 @Test
		 public void test10(){
			 String config = "value.xml";
			 ApplicationContext ac = new ClassPathXmlApplicationContext(config);
			 InfoBean ifb = ac.getBean("ifb1", InfoBean.class);
			 System.out.println(ifb);
		 }
}
