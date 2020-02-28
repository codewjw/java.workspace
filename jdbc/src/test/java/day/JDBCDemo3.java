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
	 * 批量增加108个员工
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
				//将数据暂存到ps对象里
				ps.setString(1, "好汉"+i);
				ps.setString(2, "造反"+i);
				ps.setInt(3, 0);
				ps.setDate(4,  new Date(System.currentTimeMillis()));
				ps.setDouble(5, 9000.0+i);
				ps.setDouble(6,3000.0+i);
				ps.setInt(7, 2);
				ps.addBatch();
				//每50条数据，批量提交一次
				if(i%50==0){
					//批量更新
					ps.executeBatch();
					//清空中的数据中暂存的数据便于下一次提交
					ps.clearBatch();
				}
			}
			//避免零头未执行，执行零头
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
	 * 演示增加一个部门，再给部门增加一个员工
	 * 要点:增加部门后，如何获得新增部门的ID
	 */
	@Test
	public void test2(){
		Connection conn = null;
		String deptname = "市场分析部";
		String address = "北京市中山区";
		String ename = "猪八戒";
		int mrg = 1;
		String job = "取经";
		Date hiredate = new Date(System.currentTimeMillis());
		double sal = 10000.0;
		double comm = 7000.0;
		int deptno = 0;
		try {
			conn =DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO depts VALUES(depts_seq.nextval,?,?)";
			/*
			 * 参数2是一个数组，用来告诉ps,需要它返回哪些字段
			 * 接收主键的自增涨的值，可能会有联合主键，所以用数组接收
			 */
			PreparedStatement ps = conn.prepareStatement(sql,new String[]{"deptno"});
			ps.setString(1, deptname);
			ps.setString(2, address);
			ps.executeUpdate();
			//从ps中获取生成的主键
			//结果集当中包含需要返回的列数据(这里是一行一列)
			//此方法得到的 结果集无字段名
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			//所以获取时只能用序号，不能用字段名取
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
	 * 演示分页查询员工
	 */
	@Test
	public void test3(){
	  //假设每页显示10行
		int pagesize = 10;
	  //假设用户选择第3页
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
	 * 检验查询方法和更新方法
	 */
	@Test
	public void test4(){
		Empdao  empDao = new Empdao();
		Emp emp = empDao.findEmpById(6);
		if(emp!=null){
			System.out.println(emp.getEname());
			emp.setEname("苍老师");
			empDao.modifyEmp(emp);
		}
	}
	/*
	 * 测试删除
	 */
	@Test
	public void test5(){
		Empdao  empDao = new Empdao();
		empDao.deleteEmp(6);
	}
	/*
	 * 验证新增
	 */
	@Test
	public void test6(){
		Empdao  empDao = new Empdao();
		Emp emp = new Emp();
		emp.setEmpno(0);
	    emp.setEname("猪八戒");
	    emp.setJob("软件工程师");
	    emp.setMgr(1);
	    emp.setHiredate(new Date(System.currentTimeMillis()));
	    emp.setSal(9000.00);
	    emp.setComm(2000.00);
	    emp.setDeptno(5);
		empDao.addEmp(emp);
	}
	
	/*
	 * 验证查询List<emp>
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
