package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Dept;

public class TestCase {
private SqlSession ss;
	
	//测试Mybatis连接数据库
	@Before
	public void test(){
		String config = "SqlMapConfig.xml";
		//创建SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		//获取SqlSessionFactory对象
		SqlSessionFactory ssf = ssfb.build(
		TestCase.class.getClassLoader().
		getResourceAsStream(config));
		//获取SqlSession对象
	    ss = ssf.openSession();
	}
	
    //插入操作
	@Test
	public void test1(){
		
		//调用SqlSession对象提供的方法访问数据库
		Dept dept = new Dept();
		dept.setDeptName("设计部");
		dept.setAddress("中央花园02号");
		//插入，第一参数为映射文件sql配置的id，
		//test为sql映射文件的命名空间，save为id的值
		ss.insert("practice.save", dept);
		//提交数据库操作
		ss.commit();
		//关闭SqlSession
		ss.close();
	}
	
	//查询所有员工
	@Test
	public void test2(){
		List<Dept> depts = ss.selectList("practice.findAllDepts");
		System.out.println(depts);
		//sqlsession底层会归还连接到连接池
		ss.close();
	}
	
	   //查询单个员工
		@Test
		public void test3(){
			Dept dept= ss.selectOne("practice.findDeptById",1);
			System.out.println(dept);
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		 //查询单个员工
		@Test
		public void test4(){
			Dept dept= ss.selectOne("practice.findDeptById",1);
			if(dept!=null){
				dept.setDeptName("资产财务部");
				dept.setAddress("香港路一号");
				ss.update("practice.modifyByDept", dept);
				ss.commit();
			}
			System.out.println(dept);
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
		
		 //查询单个员工
		@Test
		public void test5(){
		    ss.delete("practice.deleteById",1);
			ss.commit();
			//sqlsession底层会归还连接到连接池
			ss.close();
		}
}
