package day;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class JDBCDemo2 {

	/*
	 * 测试DBUtil的方法
	 */
	@Test
	public void test1(){
		//测试查询
		Connection conn = null;
		int empno = 2;
		try {
			conn = DBUtil.getConnection();
			//创建Statement对象
			Statement st = conn.createStatement();
			String sql = "SELECT empno,ename,job FROM emps WHERE empno >="+empno;
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getString("empno")+","+rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*
	 * 演示如何使用PreparedStatement执行数据库语句
	 * 
	 */
	@Test
	public void test2(){
		Connection conn =null;
		int empno = 3;
		String ename = "陈雯";
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE emps SET ename=? "+
			" WHERE empno=?";
			//创建ps对象并立刻发送sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//执行sql,给占位?赋值
			ps.setString(1, ename);
			ps.setInt(2, empno);
			//向数据库发送参数，并让数据库执行sql
			int rowNum = ps.executeUpdate();
			System.out.println(rowNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 如何使用PreparedStatement执行DQL语句
	 */
	@Test
	public void test3(){
		Connection conn = null;
		double salary = 6000.0;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT empno,ename,job,deptno,sal  FROM emps WHERE sal>?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, salary);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt("empno")+","
			    +rs.getString("ename")+","+rs.getDouble("sal")+
			    ","+rs.getString("job"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 使用Statement执行查询语句，测试其能否避免注入攻击
	 */
	@Test
	public void test4(){
		//假设页面传入登录条件
		String username ="'hjskjs'";
		String password ="'a' OR 'b'='b'";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		    Statement st = conn.createStatement();
		    String sql = "SELECT username FROM users WHERE username="+username+" AND password="+password;
		    ResultSet rs = st.executeQuery(sql);
		    while(rs.next()){
		    	System.out.println(rs.getString("username"));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*
	 * 使用PS执行查询语句，测试其能否避免注入攻击
	 */
	@Test
	public void test5(){
		//假设页面传入登录条件
				String username ="hjskjs";
				String password ="a OR  1=1";
				Connection conn = null;
				try {
					conn = DBUtil.getConnection();
					String sql = "SELECT username FROM users WHERE username=? AND password=?";
				    PreparedStatement ps = conn.prepareStatement(sql);
				    ps.setString(1, username);
				    ps.setString(2, password);
				    ResultSet rs = ps.executeQuery(sql);
				    if(rs.next()){
				    	System.out.println("登录成功！");
				    }
				    else{
				    	System.out.println("登录失败！");
				    }
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.close(conn);
				}
	}
	
	/*
	 * ResultSetMetaData
	 */
	@Test
	public void test6(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql ="SELECT * FROM emps ORDER BY empno";
			Statement st = conn.createStatement();
			ResultSet rs=st.executeQuery(sql);
			//获取结果集元数据
			ResultSetMetaData rsm = rs.getMetaData();
			//元数据中封装了结果集的描述信息
			//获取结果集的列数
			int columnCount = rsm.getColumnCount();
			String columnName = null;
			for(int i = 1;i<=columnCount;i++){
				//获取每一列的列名,即属性名
				columnName = rsm.getColumnName(i);
				System.out.println(columnName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*
	 * 模拟转账业务
	 * 假设用户已经登录网银，输入了收款账号,且输入了转账金额
	 * 步骤1.查询付款账号，看余额够不
	 * 2.查询收款账号，验证对否
	 * 3.修改付款余额，余额-n,修改收款金额，金额+n
	 * 一个完整的业务，要使用一个连接，保障只有一个事务，要处在一个事务内
	 */
	@Test
	public void test7(){
		Connection conn = null;
		//转账账户及转账多少钱
		double transMoney = 1000.0;
		//转账账户
		String send_account ="00001";
		//收账账户
		String receive_account ="00002";
		double remainMoney = 0.0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			//查询付款账号
			String sql = "SELECT name,money FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, send_account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			    remainMoney = rs.getDouble("money");
			}
			if(remainMoney<transMoney){ //余额够才可以转账
				System.out.println("余额不足!");
				return;
			}
			//验证收款账号
			sql = "SELECT name,money FROM accounts WHERE id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
		    ps2.setString(1, receive_account);
		    ResultSet rs2 = ps2.executeQuery();
		    double receiveMoney = 0.0;
		    if(!rs2.next()){
		    	System.out.println("收款账号有误！请重新输入收款账号！");
		    	return;
		    	
		    }else{
		    receiveMoney = rs2.getDouble("money");
		    }
		    //修改转账余额和收款金额
	    	receiveMoney += transMoney;
	    	remainMoney -= transMoney;
	    	sql = "UPDATE accounts SET money=? WHERE id=?";
	    	PreparedStatement ps3 = conn.prepareStatement(sql);
	    	ps3.setDouble(1, remainMoney);
	    	ps3.setString(2, send_account);
	    	ps3.executeUpdate();
	    	
	    	//故意异常，测试事务
	    	Integer.valueOf("断电了");
	    	
	    	PreparedStatement ps4 = conn.prepareStatement(sql);
	    	ps4.setDouble(1, receiveMoney);
	    	ps4.setString(2, receive_account);
	    	ps4.executeUpdate();
	    	//提交事务
	    	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}catch (Exception e){
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
}
