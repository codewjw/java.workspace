package spring;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class firstSpring {
    public static void main(String[] args){
    	String config = "applicationContext.xml";
    	/*
    	 * ApplicationContext是接口
    	 * ClassPathXmlApplicationContext是一个实现类，该类会依据类路径
    	 * 取查找spring配置文件，然后启动spring容器
    	 */
    	ApplicationContext ac = new ClassPathXmlApplicationContext(config);
    	//Student.class是方法区中的class对象
    	//第一个参数为bean的id
        Student stu = ac.getBean("stu1",Student.class);
        System.out.println(stu);
        
        Date date = ac.getBean("date",Date.class);
        System.out.println(date);
        
        Calendar cal1 = ac.getBean("cal1",Calendar.class);
        System.out.println(cal1);
       
        Date date2 = ac.getBean("time1",Date.class);
        System.out.println(date2);
        
    }
}
