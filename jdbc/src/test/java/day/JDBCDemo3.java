package day;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.Empdao;
import entity.Emp;
import util.DBUtil;

public class JDBCDemo3 {

	/*
	 * ��������108��Ա��
	 */
	@Test
	public void test1(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO emps VALUES(emps_seq.nextval,"
			+"?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			for(int i=1;i<=108;i++){
				//�������ݴ浽ps������
				ps.setString(1, "�ú�"+i);
				ps.setString(2, "�췴"+i);
				ps.setInt(3, 0);
				ps.setDate(4,  new Date(System.currentTimeMillis()));
				ps.setDouble(5, 9000.0+i);
				ps.setDouble(6,3000.0+i);
				ps.setInt(7, 2);
				ps.addBatch();
				//ÿ50�����ݣ������ύһ��
				if(i%50==0){
					//��������
					ps.executeBatch();
					//����е��������ݴ�����ݱ�����һ���ύ
					ps.clearBatch();
				}
			}
			//������ͷδִ�У�ִ����ͷ
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ��ʾ����һ�����ţ��ٸ���������һ��Ա��
	 * Ҫ��:���Ӳ��ź���λ���������ŵ�ID
	 */
	@Test
	public void test2(){
		Connection conn = null;
		String deptname = "�г�������";
		String address = "��������ɽ��";
		String ename = "��˽�";
		int mrg = 1;
		String job = "ȡ��";
		Date hiredate = new Date(System.currentTimeMillis());
		double sal = 10000.0;
		double comm = 7000.0;
		int deptno = 0;
		try {
			conn =DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO depts VALUES(depts_seq.nextval,?,?)";
			/*
			 * ����2��һ�����飬��������ps,��Ҫ��������Щ�ֶ�
			 * ���������������ǵ�ֵ�����ܻ��������������������������
			 */
			PreparedStatement ps = conn.prepareStatement(sql,new String[]{"deptno"});
			ps.setString(1, deptname);
			ps.setString(2, address);
			ps.executeUpdate();
			//��ps�л�ȡ���ɵ�����
			//��������а�����Ҫ���ص�������(������һ��һ��)
			//�˷����õ��� ��������ֶ���
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			//���Ի�ȡʱֻ������ţ��������ֶ���ȡ
			deptno = rs.getInt(1);
			sql = "INSERT INTO emps VALUES(emps_seq.nextval,?,?,?,?,?,?,?)";
			PreparedStatement ps2 = conn.prepareStatement(sql);
			ps2.setString(1, ename);
			ps2.setString(2, job);
			ps2.setInt(3,mrg);
			ps2.setDate(4, hiredate);
			ps2.setDouble(5, sal);
			ps2.setDouble(6, comm);
			ps2.setInt(7, deptno);
			ps2.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(conn);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*
	 * ��ʾ��ҳ��ѯԱ��
	 */
	@Test
	public void test3(){
	  //����ÿҳ��ʾ10��
		int pagesize = 10;
	  //�����û�ѡ���3ҳ
	   int pageNum = 3;
	   int start = (pageNum-1)*pagesize+1;
	   int end = pageNum*pagesize;
	   Connection conn = null;
	   try {
		conn = DBUtil.getConnection();
		String sql = "SELECT * FROM (SELECT e.*,ROWNUM rn FROM ("
		   +" SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno FROM emps ORDER BY empno) e"
				+" WHERE ROWNUM<=?) t WHERE t.rn>=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, end);
		ps.setInt(2, start);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("ename")+","+rs.getInt("empno")+","
		     +rs.getString("job")+","+rs.getDouble("sal"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	/*
	 * �����ѯ�����͸��·���
	 */
	@Test
	public void test4(){
		Empdao  empDao = new Empdao();
		Emp emp = empDao.findEmpById(6);
		if(emp!=null){
			System.out.println(emp.getEname());
			emp.setEname("����ʦ");
			empDao.modifyEmp(emp);
		}
	}
	/*
	 * ����ɾ��
	 */
	@Test
	public void test5(){
		Empdao  empDao = new Empdao();
		empDao.deleteEmp(6);
	}
	/*
	 * ��֤����
	 */
	@Test
	public void test6(){
		Empdao  empDao = new Empdao();
		Emp emp = new Emp();
		emp.setEmpno(0);
	    emp.setEname("��˽�");
	    emp.setJob("�������ʦ");
	    emp.setMgr(1);
	    emp.setHiredate(new Date(System.currentTimeMillis()));
	    emp.setSal(9000.00);
	    emp.setComm(2000.00);
	    emp.setDeptno(5);
		empDao.addEmp(emp);
	}
	
	/*
	 * ��֤��ѯList<emp>
	 */
	@Test
	public void test7(){
		Empdao  empDao = new Empdao();
	    List<Emp> emps = new ArrayList<Emp>();
	    emps = empDao.findEmpsByDept(1);
	    for(Emp emp:emps){
	    	System.out.println(emp.getEname());
	    }
	  }
}
