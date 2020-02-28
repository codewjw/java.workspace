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
	 * ����DBUtil�ķ���
	 */
	@Test
	public void test1(){
		//���Բ�ѯ
		Connection conn = null;
		int empno = 2;
		try {
			conn = DBUtil.getConnection();
			//����Statement����
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
	 * ��ʾ���ʹ��PreparedStatementִ�����ݿ����
	 * 
	 */
	@Test
	public void test2(){
		Connection conn =null;
		int empno = 3;
		String ename = "����";
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE emps SET ename=? "+
			" WHERE empno=?";
			//����ps�������̷���sql
			PreparedStatement ps = conn.prepareStatement(sql);
			//ִ��sql,��ռλ?��ֵ
			ps.setString(1, ename);
			ps.setInt(2, empno);
			//�����ݿⷢ�Ͳ������������ݿ�ִ��sql
			int rowNum = ps.executeUpdate();
			System.out.println(rowNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ���ʹ��PreparedStatementִ��DQL���
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
	 * ʹ��Statementִ�в�ѯ��䣬�������ܷ����ע�빥��
	 */
	@Test
	public void test4(){
		//����ҳ�洫���¼����
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
	 * ʹ��PSִ�в�ѯ��䣬�������ܷ����ע�빥��
	 */
	@Test
	public void test5(){
		//����ҳ�洫���¼����
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
				    	System.out.println("��¼�ɹ���");
				    }
				    else{
				    	System.out.println("��¼ʧ�ܣ�");
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
			//��ȡ�����Ԫ����
			ResultSetMetaData rsm = rs.getMetaData();
			//Ԫ�����з�װ�˽������������Ϣ
			//��ȡ�����������
			int columnCount = rsm.getColumnCount();
			String columnName = null;
			for(int i = 1;i<=columnCount;i++){
				//��ȡÿһ�е�����,��������
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
	 * ģ��ת��ҵ��
	 * �����û��Ѿ���¼�������������տ��˺�,��������ת�˽��
	 * ����1.��ѯ�����˺ţ�������
	 * 2.��ѯ�տ��˺ţ���֤�Է�
	 * 3.�޸ĸ��������-n,�޸��տ�����+n
	 * һ��������ҵ��Ҫʹ��һ�����ӣ�����ֻ��һ������Ҫ����һ��������
	 */
	@Test
	public void test7(){
		Connection conn = null;
		//ת���˻���ת�˶���Ǯ
		double transMoney = 1000.0;
		//ת���˻�
		String send_account ="00001";
		//�����˻�
		String receive_account ="00002";
		double remainMoney = 0.0;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			//��ѯ�����˺�
			String sql = "SELECT name,money FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, send_account);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			    remainMoney = rs.getDouble("money");
			}
			if(remainMoney<transMoney){ //���ſ���ת��
				System.out.println("����!");
				return;
			}
			//��֤�տ��˺�
			sql = "SELECT name,money FROM accounts WHERE id=?";
			PreparedStatement ps2 = conn.prepareStatement(sql);
		    ps2.setString(1, receive_account);
		    ResultSet rs2 = ps2.executeQuery();
		    double receiveMoney = 0.0;
		    if(!rs2.next()){
		    	System.out.println("�տ��˺����������������տ��˺ţ�");
		    	return;
		    	
		    }else{
		    receiveMoney = rs2.getDouble("money");
		    }
		    //�޸�ת�������տ���
	    	receiveMoney += transMoney;
	    	remainMoney -= transMoney;
	    	sql = "UPDATE accounts SET money=? WHERE id=?";
	    	PreparedStatement ps3 = conn.prepareStatement(sql);
	    	ps3.setDouble(1, remainMoney);
	    	ps3.setString(2, send_account);
	    	ps3.executeUpdate();
	    	
	    	//�����쳣����������
	    	Integer.valueOf("�ϵ���");
	    	
	    	PreparedStatement ps4 = conn.prepareStatement(sql);
	    	ps4.setDouble(1, receiveMoney);
	    	ps4.setString(2, receive_account);
	    	ps4.executeUpdate();
	    	//�ύ����
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
