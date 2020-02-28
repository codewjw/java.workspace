package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao implements Serializable {

	public List<Cost> findAll(){
		Connection conn = null;
		List<Cost> costs = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT cost_id,name,base_duration,base_cost,"
					+ "unit_cost,status,descr,creatime,startime,cost_type"+
					" FROM cost ORDER BY cost_id";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			costs = new ArrayList<Cost>();
			while(rs.next()){
				Cost cost = new Cost();
				cost = setCost(cost,rs);
				costs.add(cost);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("创建连接失败！",e);
		}finally{
			DBUtil.close(conn);
		}
		return costs;
	}
	
	public void addCost(Cost cost){
		
      Connection conn = null;
      try {
		conn = DBUtil.getConnection();
		String sql = "INSERT INTO cost VALUES("+
		" cost_seq.nextval,?,?,?,?,'1',?,sysdate,null,? )";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cost.getName());
		//setInt,setLong,setDouble不允许传入null,而数据库支持null,可已经这样的字段当Object来处理
		ps.setLong(2, cost.getBaseDuration());
		ps.setDouble(3,cost.getBaseCost());
		ps.setDouble(4, cost.getUnitCose());
		ps.setString(5, cost.getDescr());
		ps.setString(6,cost.getCostType());
		ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("增加资费失败！",e);
		}finally{
			DBUtil.close(conn);
		}
      
	}
	
	//根据id查询 
	public Cost queryCostById(int id){
		Connection conn = null;
		Cost cost = new Cost();
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT cost_id,name,base_duration,base_cost,"
					+ "unit_cost,status,descr,creatime,startime,cost_type"+
					" FROM cost WHERE cost_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cost = setCost(cost,rs);
			}else{
				cost = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败！未找到该条记录！");
		}finally{
			DBUtil.close(conn);
		}
		
		return cost;
	}
	//更新数据
	public void updateCost(Cost cost){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE cost SET name=?,base_duration=?,base_cost=?,"
					+ " unit_cost=?,descr=?,creaTime=sysdate,cost_type=? WHERE"+
					" cost_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cost.getName());
			//setInt,setLong,setDouble不允许传入null,而数据库支持null,可已经这样的字段当Object来处理
			ps.setLong(2, cost.getBaseDuration());
			ps.setDouble(3,cost.getBaseCost());
			ps.setDouble(4, cost.getUnitCose());
			ps.setString(5, cost.getDescr());
			ps.setString(6,cost.getCostType());
			ps.setInt(7, cost.getCostId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("更新失败！",e);
		}finally{
			DBUtil.close(conn);
		}
		
	}
	
	//设置cost对象
	public Cost setCost(Cost cost,ResultSet rs){
		try {
			cost.setCostId(rs.getInt("cost_id"));
			cost.setName(rs.getString("name"));
			cost.setBaseDuration(rs.getLong("base_duration"));
			cost.setBaseCost(rs.getDouble("base_cost"));
			cost.setUnitCose(rs.getDouble("unit_cost"));
			cost.setStatus(rs.getString("status"));
			cost.setDescr(rs.getString("descr"));
			cost.setCreaTime(rs.getTimestamp("creatime"));
			cost.setStartime(rs.getTimestamp("startime"));
			cost.setCostType(rs.getString("cost_type"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("设置对象失败！",e);
		}
		return cost;
	}
   
	/*public static void main(String args[]){
		CostDao cd = new CostDao();
		Cost cost = new Cost();
		cost.setCostId(2);
		cost.setName("7.8元套餐");
		cost.setBaseDuration(100L);
		cost.setBaseCost(7.8);
		cost.setUnitCose(0.2);
		cost.setStatus("1");
		cost.setDescr("神经病");
		cost.setCostType("2");
		cd.updateCost(cost);
	}*/
}
