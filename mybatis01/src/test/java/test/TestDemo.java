package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;

public class TestDemo {
	
	private SqlSession ss;
	
	//测试Mybatis连接数据库
	@Before
	public void test(){
		String config = "SqlMapConfig.xml";
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//获取SqlSessionFactory对象
		SqlSessionFactory ssf = ssfb.build(
		TestDemo.class.getClassLoader().
		getResourceAsStream(config));
		//获取SqlSession对象
	    ss = ssf.openSession();
	}
	
    //插入操作
	@Test
	public void test1(){
		
		//调用SqlSession对象提供的方法访问数据库
		Emp emp = new Emp();
		emp.setName("hary");
		emp.setAge(30);
		//插入，第一参数为映射文件sql配置的id，
		//test为sql映射文件的命名空间，save为id的值
		ss.insert("test.save", emp);
		//提交数据库操作
		ss.commit();
		//关闭SqlSession
		ss.close();
	}
	
	//查询所有员工
	@Test
	public void test2(){
		List<Emp> emps = ss.selectList("test.findAllEmps");
		System.out.println(emps);
		//sqlsession底层会归还连接到连接池
		ss.close();
	}
	
	   //查询单个员工
		@Test
		public void test3(){
			Emp emp= ss.selectOne("test.findEmpById",21);
			System.out.println(emp);
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		 //查询单个员工
		@Test
		public void test4(){
			Emp emp= ss.selectOne("test.findEmpById",21);
			if(emp!=null){
				emp.setName("chenwenjie");
				emp.setAge(emp.getAge()*2);
				ss.update("test.modifyByEmp", emp);
				ss.commit();
			}
			System.out.println(emp);
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		 //查询单个员工
		@Test
		public void test5(){
		    ss.delete("test.deleteById",21);
			ss.commit();
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		//测试返回Map类型的结果
		@Test
		public void test6(){
			Map data = ss.selectOne("test.findEmpById2", 22);
			System.out.println(data);
			//注：Oracle数据库会将字段名统一变成大写形式
			System.out.println(data.get("NAME"));
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		//测试返回Map类型的结果
		@Test
		public void test7(){
			Employee emp = ss.selectOne("test.findEmpById3", 22);
			System.out.println(emp);
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
}
