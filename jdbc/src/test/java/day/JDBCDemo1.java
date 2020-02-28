package day;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;
/**
 * JUnit：
 * @author Administrator
 *1.允许一个类中的多个方法都能单独执行
 *2.需要在方法之前加上@Test注解才能让它单独执行
 *3.方法必须是共有的，无返回值的，无参数的
 *4.正式的WEB项目中,代码需要拷贝到服务器里执行,Eclipse在拷贝代码时会
 *抛弃测试代码，所以JUnit的包将来也会被抛弃，就无需使用maven来导入这样的包了
 */
public class JDBCDemo1 {
 
	/*
	 * 创建数据库连接
	 */
	 @Test
	 public void test1(){
		 Connection conn = null;
		 try {
			//注册驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//创建连接
			/*
			 * 第一个参数是连接数据库的地址、端口及sid
			 * 第二个参数是登录名
			 * 第三个参数是登录密码
			 */
		    conn = DriverManager.getConnection(
		    		"jdbc:oracle:thin:@localhost:1521:xe",
		    		"system","123456");
		
		    System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
				e.printStackTrace();
	    }finally{
	    		try {
	    			if(conn!=null){
					 conn.close();
	    			}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	    }
	 }
	 /*
	  * 读取properties文件
	  * 1.使用java.util.Properties类
	  * 2.它本质上就是Map,继承于Hashtable
	  * 3.它专门用来读取properties文件
	  */
	 @Test
	 public void test2(){
		System.out.println("2");
		Properties p = new Properties();
		try {
			/*
			 * 获取class文件对应下的db.properties文件
			 * 使用ClasssLoader从class下读取db.properties文件
			*/
			p.load(JDBCDemo1.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			String driver=p.getProperty("driver");
			System.out.println(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 /*
	  * 测试DBTool.getConncetion()方法
	  * 执行insert语句
	  */
	 @Test
	 public void Test3(){
	   Connection conn = null;
		try {
			//创建连接
			conn = DBTool.getConnection();
			//创建Statement，执行sql
			Statement smt = conn.createStatement();
			//sql中不要写分号结束
			String sql ="INSERT INTO emps VALUES(emps_seq.nextval,'陈小明'"+
			             ",'项目经理',0,sysdate,15000.0,3000.0,1) ";
			sql = "DELETE FROM emps WHERE empno = 4";
			//执行SQL
			int row = smt.executeUpdate(sql);
			//返回修改、增加、删除了几行
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		} 
	 }
	 
	 /**
	  * 如何执行查询语句
	  */
	 @Test
	 public void test4(){
		 Connection ct =null;
		 try {
			ct = DBTool.getConnection();
			Statement st = ct.createStatement();
			//ctrl+shift+x/y大小写转换，选中要转换的单词
			String sql = "SELECT empno,ename,job,mgr,hiredate,sal,deptno,"+
			             "comm FROM emps WHERE deptno = 1 ORDER BY empno";
			/*
			 * 返回ResultSet是结果集，封装了查询的结果，该结果是多行多列的，
			 * 该对象采用迭代器模式设计而来的
			 * 迭代器模式通常使用while遍历
			*/
			ResultSet rs = st.executeQuery(sql);
			/*
			 * 每次next()获取下一行数据
			 */
			while(rs.next()){
			 /*
			  * 获取该行的每一列的值
			  * rs.get类型(字段的序号)
			  * rs.get类型(字段的名称)
			  */
				
				System.out.println(rs.getInt("empno")+","+rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(ct);
		}
	 }
	 
	 @Test
	 public void test5(){
		 Connection cn = null;
		 try {
			cn = DBTool.getConnection();
			Statement st = cn.createStatement();
			String sql ="UPDATE emps SET ename='悟空' WHERE empno=6";
			int index = st.executeUpdate(sql);
			System.out.println(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(cn);
		}
	 }
	 
	 
}
