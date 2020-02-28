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
 * �־ò�ע��
 * @Repository("adminDAO")��adminDAO��bean��id
 * @Repository("adminDAO")
 */

public class AdminDaoJdbcImpl implements AdminDao{
	//���ӳض���
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
			//step1. ����־(�����ֳ�)
			e.printStackTrace();
			/*
			 * step2.���쳣�ܷ�ָ���������ܹ��ָ�(�������ݿ������ͣ��
			 * �����жϣ��������쳣һ�����ǳ�֮Ϊϵͳ�쳣)������ʾ�û��Ժ�����
			 * ����ܹ��ָ��������ָ�
			 * 
			 */
			throw new RuntimeException(e);
		}finally{
			close(conn);
		}
		return admin;
	}
	
	//��AdminInfo�趨ֵ
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
			throw new RuntimeException("��ѯʧ�ܣ�",e);
		}
    	return admin;
    }
    
    /*
     * �ر�����
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
