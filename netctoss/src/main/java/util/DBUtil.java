package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//���ӳض�����dbcp�ṩ
    private static BasicDataSource bds;
    
    static{
    	Properties p = new Properties();
    	try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//�������ӳ�
			bds = new BasicDataSource();
			//���ò���
			//���ӳ�ʹ��driver����ע������
			bds.setDriverClassName(driver);
			//��������·������¼����¼�û��������룬ʹ����������������������
			bds.setUrl(url);
			bds.setUsername(user);
			bds.setPassword(pwd);
			//���ӳػ�ʹ������������������
			bds.setInitialSize(Integer.parseInt(initsize));
			bds.setMaxActive(Integer.parseInt(maxsize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.properties�ļ�ʧ��",e);
		}
    }
    //��ȡ����
    public static Connection getConnection() throws SQLException{
    	//ʹ�����ӳ�����������
    	return bds.getConnection();
    }
    /*
     * �黹����
     * �����ӳش��������ӣ����ӵ�close���������ӳ���д�ˣ�����˹黹���ӵ��߼�
     * �������ӳػὫ���ӵ�״̬����Ϊ���У���������������������κ�����
     */
    public static void close(Connection conn){
	    	try {
	    		if(conn!=null){
				  conn.close();
			  }
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�黹�����쳣",e);
			}
 
    }
    
    /*
     * �ع�����
     */
    public static void rollback(Connection conn){
    	try {
    		if(conn!=null){
			  conn.rollback();
		  }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�ع��쳣",e);
		}
    }
    
  /*  public static void main(String[] args){
    	try {
			Connection conn = DBUtil.getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }*/
}
