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
 * JUnit��
 * @author Administrator
 *1.����һ�����еĶ���������ܵ���ִ��
 *2.��Ҫ�ڷ���֮ǰ����@Testע�������������ִ��
 *3.���������ǹ��еģ��޷���ֵ�ģ��޲�����
 *4.��ʽ��WEB��Ŀ��,������Ҫ��������������ִ��,Eclipse�ڿ�������ʱ��
 *�������Դ��룬����JUnit�İ�����Ҳ�ᱻ������������ʹ��maven�����������İ���
 */
public class JDBCDemo1 {
 
	/*
	 * �������ݿ�����
	 */
	 @Test
	 public void test1(){
		 Connection conn = null;
		 try {
			//ע������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//��������
			/*
			 * ��һ���������������ݿ�ĵ�ַ���˿ڼ�sid
			 * �ڶ��������ǵ�¼��
			 * �����������ǵ�¼����
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
	  * ��ȡproperties�ļ�
	  * 1.ʹ��java.util.Properties��
	  * 2.�������Ͼ���Map,�̳���Hashtable
	  * 3.��ר��������ȡproperties�ļ�
	  */
	 @Test
	 public void test2(){
		System.out.println("2");
		Properties p = new Properties();
		try {
			/*
			 * ��ȡclass�ļ���Ӧ�µ�db.properties�ļ�
			 * ʹ��ClasssLoader��class�¶�ȡdb.properties�ļ�
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
	  * ����DBTool.getConncetion()����
	  * ִ��insert���
	  */
	 @Test
	 public void Test3(){
	   Connection conn = null;
		try {
			//��������
			conn = DBTool.getConnection();
			//����Statement��ִ��sql
			Statement smt = conn.createStatement();
			//sql�в�Ҫд�ֺŽ���
			String sql ="INSERT INTO emps VALUES(emps_seq.nextval,'��С��'"+
			             ",'��Ŀ����',0,sysdate,15000.0,3000.0,1) ";
			sql = "DELETE FROM emps WHERE empno = 4";
			//ִ��SQL
			int row = smt.executeUpdate(sql);
			//�����޸ġ����ӡ�ɾ���˼���
			System.out.println(row);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		} 
	 }
	 
	 /**
	  * ���ִ�в�ѯ���
	  */
	 @Test
	 public void test4(){
		 Connection ct =null;
		 try {
			ct = DBTool.getConnection();
			Statement st = ct.createStatement();
			//ctrl+shift+x/y��Сдת����ѡ��Ҫת���ĵ���
			String sql = "SELECT empno,ename,job,mgr,hiredate,sal,deptno,"+
			             "comm FROM emps WHERE deptno = 1 ORDER BY empno";
			/*
			 * ����ResultSet�ǽ��������װ�˲�ѯ�Ľ�����ý���Ƕ��ж��еģ�
			 * �ö�����õ�����ģʽ��ƶ�����
			 * ������ģʽͨ��ʹ��while����
			*/
			ResultSet rs = st.executeQuery(sql);
			/*
			 * ÿ��next()��ȡ��һ������
			 */
			while(rs.next()){
			 /*
			  * ��ȡ���е�ÿһ�е�ֵ
			  * rs.get����(�ֶε����)
			  * rs.get����(�ֶε�����)
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
			String sql ="UPDATE emps SET ename='���' WHERE empno=6";
			int index = st.executeUpdate(sql);
			System.out.println(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBTool.close(cn);
		}
	 }
	 
	 
}
