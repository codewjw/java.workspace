package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;
import util.DBUtil;

public class Empdao implements Serializable{
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * ??????????
	 */
	public void addEmp(Emp emp){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO emps VALUES(emps_seq.nextval,"+
			       "?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2,emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4,emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7,  emp.getDeptno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("?????????",e);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	
	/*
	 * ????id?????????
	 */
	public void modifyEmp(Emp emp){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE emps SET ename=?,job=?,mgr=?,"
					+ "hiredate=?,sal=?,comm=?,deptno=? WHERE empno=?";
			PreparedStatement ps = conn.prepareCall(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2,emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4,emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7,  emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("??????",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/*
	 * ????id???????????
	 */
	public void deleteEmp(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM emps WHERE empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("??????",e);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	
	/*
	 * ???????id??????
	 */
	public Emp findEmpById(int id){
		Connection conn = null;
		Emp emp= new Emp();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM emps WHERE empno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				return emp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("???????"+e);
		}
		return null;
	}
	
	/*
	 * ????????????
	 */
	public List<Emp> findEmpsByDept(int deptno){
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;
		Connection conn = null;
		try {
			conn =DBUtil.getConnection();
			String sql = "SELECT * FROM emps WHERE deptno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, deptno);
		    ResultSet rs = ps.executeQuery();
		    while(rs.next()){
		        emp = new Emp();	
			 	emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emps.add(emp);
		    }
		    if(emps.size()>0){
		    	return emps;
		    }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("??????",e);
		}
		
		return null;
	}
}
