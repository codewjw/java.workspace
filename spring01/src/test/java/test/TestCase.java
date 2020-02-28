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
    	 * ApplicationContext�ǽӿ�
    	 * ClassPathXmlApplicationContext��һ��ʵ���࣬�����������·��
    	 * ȡ����spring�����ļ���Ȼ������spring����
    	 */
		//����Spring����,Ĭ�������,�����Ὣconfig�ļ��а�����bean(������Ϊ������bean)��Ӧ�Ķ��󴴽���
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Teacher teac1 = ac.getBean("teac1",Teacher.class);
		Teacher teac2 = ac.getBean("teac1",Teacher.class);
		//singleton:Ĭ�������true:˵��ֻ����һ����������������������ĵ�ַ��ͬ
		//prototype�������½��Ϊfalse��˵��������������
		System.out.println(teac1==teac2);
	}
	
	@Test
	public void test2(){
		String config = "basic.xml";
		/*
    	 * ApplicationContext�ǽӿ�
    	 * ClassPathXmlApplicationContext��һ��ʵ���࣬�����������·��
    	 * ȡ����spring�����ļ���Ȼ������spring����
    	 */
		//����Spring����,Ĭ�������,�����Ὣconfig�ļ��а�����bean(������Ϊ������bean)��Ӧ�Ķ��󴴽���
		/*
		 * ApplicationContext�в�û���ṩ�ر������ķ���(close())
		 * ��Ҫ�����ӽӿ�
		 */
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext(config);
        MessageService ms = ac.getBean("msg1",MessageService.class);
        
        //�ر�����
        ac.close();
	}
	
	@Test
	public void test3(){
		String config = "applicationContext.xml";
		/*
    	 * ApplicationContext�ǽӿ�
    	 * ClassPathXmlApplicationContext��һ��ʵ���࣬�����������·��
    	 * ȡ����spring�����ļ���Ȼ������spring����
    	 */
		//����Spring����,Ĭ�������,�����Ὣconfig�ļ��а�����bean(������Ϊ������bean)��Ӧ�Ķ��󴴽���
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Calendar cal1 = ac.getBean("cal1",Calendar.class);
		//singleton:Ĭ�������true:˵��ֻ����һ����������������������ĵ�ַ��ͬ
		//prototype�������½��Ϊfalse��˵��������������
		System.out.println(cal1);
	}
	
	@Test
	public void test4(){
		String config = "applicationContext.xml";
		/*
    	 * ApplicationContext�ǽӿ�
    	 * ClassPathXmlApplicationContext��һ��ʵ���࣬�����������·��
    	 * ȡ����spring�����ļ���Ȼ������spring����
    	 */
		//����Spring����,Ĭ�������,�����Ὣconfig�ļ��а�����bean(������Ϊ������bean)��Ӧ�Ķ��󴴽���
		ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        
		Date time1 = ac.getBean("time1",Date.class);
		//singleton:Ĭ�������true:˵��ֻ����һ����������������������ĵ�ַ��ͬ
		//prototype�������½��Ϊfalse��˵��������������
		System.out.println(time1);
	}
}
