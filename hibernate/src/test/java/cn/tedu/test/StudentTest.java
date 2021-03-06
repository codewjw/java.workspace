package cn.tedu.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

import cn.tedu.entity.Student;

public class StudentTest {
 
     Session session;
	
	@Before
	public void beforeTest(){
		Configuration cfg = new Configuration();
		//读取主配置文件
		cfg.configure("hibernate.cfg.xml");
		//获取session对象
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}
	
	@Test
	public void test1(){
		//创建事务
		Transaction tran = session.beginTransaction();
		//开启事务
		tran.begin();
		Student stu = new Student();
		stu.setName("Alice");
		System.out.println(stu);
		session.save(stu);
		System.out.println(stu);
		//提交事务
		tran.commit();
		//关闭session
		session.close();
	}
	/**
	 * 临时变持久
	 */
	@Test
	public void testUpdate(){
		//创建事务
		Transaction tran = session.beginTransaction();
		//开启事务
		tran.begin();
		Student stu = (Student) session.get(Student.class, 4); //进入持久态
		System.out.println(stu);
		stu.setName("Jim"); //持久态，对象和数据同步，对象中属性数据改了，会直接修改数据库中数据
		System.out.println(stu);
        //提交事务
		tran.commit();
		//关闭session
		session.close();
	}
	
	/**
	 * 持久状态变临时状态
	 */
	@Test
	public void testDelete(){
		Transaction tran = session.beginTransaction();
		tran.begin();
		Student stu = (Student) session.get(Student.class, 4);//临时态进入持久态
		System.out.println(stu);
		session.delete(stu);//持久态变临时态
		tran.commit();
		System.out.println(stu);
		session.close();
	}
	
	/**
	 * 持久状态变游离状态
	 */
	@Test
	public void testEvict(){
		Transaction tran = session.beginTransaction();
		tran.begin();
		Student stu = (Student) session.get(Student.class, 1);
		System.out.println(stu);
		//清除session中的一个对象
		session.evict(stu);
		stu.setName("bom");
		System.out.println(stu);
		tran.commit();
		session.close();
	}
	
	/**
	 * 游离状态变持久状态
	 */
	@Test
	public void testObjUpdate(){
		Transaction tran = session.beginTransaction();
		tran.begin();
		Student stu = (Student) session.get(Student.class, 1);//临时状态进入持久态
		System.out.println(stu);
		//清除session中的一个对象
		session.evict(stu); //从持久状态变成游离态
		stu.setName("bom");
		session.update(stu); //从游离态变成持久态
		System.out.println(stu);
		tran.commit();
		session.close();
	}
	
	@Test
	public void testHQLSelect(){
		//编写HQL语句
		String hql = "from Student";
		//创建查询Query对象
		Query query = session.createQuery(hql);
		//调用list()方法查询数据
		List<Student> list = query.list();
		for(Student stu:list){
			System.out.println(stu);
		}
		session.close();
	}
	
	@Test
	public void testHQLSelect2(){
		//1.创建session对象
		//2.编写HQL语句
		//String hql = "from Student where id=:id";
		String hql = "from Student where name=:username";
		//3.创建查询Query对象
		Query query = session.createQuery(hql);
		//4.设置参数
		//query.setInteger("id", 2);
		query.setString("username", "Alice");
		//5.调用list()方法查询数据
		List<Student> list = query.list();
		for(Student stu:list){
			System.out.println(stu);
		}
		//6.关闭session
		session.close();
	}
	
	@Test
	public void testHQLSelect3(){
		//2.编写HQL语句
		//String hql = "from Student where id=:id";
		String hql = "from Student order by id desc";
		//3.创建查询Query对象
		Query query = session.createQuery(hql);
		//5.调用list()方法查询数据
		List<Student> list = query.list();
		for(Student stu:list){
			System.out.println(stu);
		}
		//6.关闭session
		session.close();
	}
	
	//缓存的应用
	@Test
	public void testCache(){
		//Transaction tran = session.beginTransaction();
		//tran.begin();
		//执行查询,第一次会到数据库中查询，同时会将数据存入第一级session缓存中
		//会在控制台输出sql语句
		Student stu = (Student) session.get(Student.class, 1);
		System.out.println(stu);
		Student stu2 = (Student) session.get(Student.class, 1);
		System.out.println(stu2);
		//为true，说明stu和stu2地址相同，则第二次查询数据来源于session缓存，没有进入数据库查询
		//所以执行的sql都没有输出在控制台
		System.out.println(stu==stu2); 
		//tran.commit();
		session.close();
	}
}
