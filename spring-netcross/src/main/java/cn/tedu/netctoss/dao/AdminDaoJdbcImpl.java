package cn.tedu.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.entity.Admin;
/*
 * 持久层注解
 * @Repository("adminDAO")中adminDAO是bean的id
 * @Repository("adminDAO")
 */

public class AdminDaoJdbcImpl implements AdminDao{
	//连接池对象
	@Resource(name="datasource")
	private DataSource ds;

	public Admin findAdminByCode(String adminCode) {
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT admin_id,admin_code,password,"
					+ "name,telephone,email,enrolldate FROM admin_info WHERE admin_code=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				setAdmin(admin,rs);
			}
		} catch (SQLException e) {
			//step1. 记日志(保留现场)
			e.printStackTrace();
			/*
			 * step2.看异常能否恢复，如果不能够恢复(比如数据库服务暂停，
			 * 网络中断，这样的异常一般我们称之为系统异常)，则提示用户稍后重试
			 * 如果能够恢复则立即恢复
			 * 
			 */
			throw new RuntimeException(e);
		}finally{
			close(conn);
		}
		return admin;
	}
	
	//给AdminInfo设定值
    public Admin setAdmin(Admin admin,ResultSet rs){
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
			throw new RuntimeException("查询失败！",e);
		}
    	return admin;
    }
    
    /*
     * 关闭连接
     */
    public void close(Connection conn){
        try{
        	if(conn!=null){
        		conn.close();
        	}
        }catch(SQLException e){
        	e.printStackTrace();
			throw new RuntimeException(e);
        }
    	
    }

	public List<Admin> findAllAdmins() {
		// TODO Auto-generated method stub
		return null;
	}

}
