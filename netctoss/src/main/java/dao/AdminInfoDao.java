package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.AdminInfo;
import util.DBUtil;

public class AdminInfoDao implements Serializable{
	
    public AdminInfo queryAdminByName(String adminCode){
    	Connection conn = null;
    	AdminInfo admin = new AdminInfo();
    	try {
			conn = DBUtil.getConnection();
			String sql = "SELECT admin_id,admin_code,password,"
					+ "name,telephone,email,enrolldate FROM admin_info WHERE admin_code=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			 setAdmin(admin,rs);
			}else{
				admin = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("µÇÂ¼Ê§°Ü£¡",e);
		}finally{
			DBUtil.close(conn);
		}
    	return admin;
    }
    
    //¸øAdminInfoÉè¶¨Öµ
    public AdminInfo setAdmin(AdminInfo admin,ResultSet rs){
    	try {
			admin.setAdminId(rs.getInt("admin_id"));
			admin.setAdminCode(rs.getString("admin_code"));
			admin.setName(rs.getString("name"));
			admin.setPassword(rs.getString("password"));
			admin.setEmail(rs.getString("email"));
			admin.setTelephone(rs.getString("telephone"));
			admin.setEnrolldate(rs.getTimestamp("enrolldate"));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("µÇÂ¼Ê§°Ü£¡",e);
		}
    	return admin;
    }
    
  /*  public static void main(String[] args){
    	AdminInfoDao aid= new AdminInfoDao();
    	AdminInfo ai = aid.queryAdminByName("CaoCao");
    	System.out.println(ai.getName()+","+ai.getEmail());	
    }*/
}
