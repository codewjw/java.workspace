package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	//连接池对象，由dbcp提供
    private static BasicDataSource bds;
    
    static{
    	Properties p = new Properties();
    	try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//读取参数
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//创建连接池
			bds = new BasicDataSource();
			//设置参数
			//连接池使用driver参数注册驱动
			bds.setDriverClassName(driver);
			//设置连接路径，登录数据录用户名、密码，使用下面三个参数创建连接
			bds.setUrl(url);
			bds.setUsername(user);
			bds.setPassword(pwd);
			//连接池会使用其他参数管理连接
			bds.setInitialSize(Integer.parseInt(initsize));
			bds.setMaxActive(Integer.parseInt(maxsize));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载db.properties文件失败",e);
		}
    }
    //获取连接
    public static Connection getConnection() throws SQLException{
    	//使用连接池来创建连接
    	return bds.getConnection();
    }
    /*
     * 归还连接
     * 由连接池创建的连接，连接的close方法被连接池重写了，变成了归还连接的逻辑
     * 即：连接池会将连接的状态设置为空闲，并清空连接中所保安的任何数据
     */
    public static void close(Connection conn){
	    	try {
	    		if(conn!=null){
				  conn.close();
			  }
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("归还连接异常",e);
			}
 
    }
    
    /*
     * 回滚事务
     */
    public static void rollback(Connection conn){
    	try {
    		if(conn!=null){
			  conn.rollback();
		  }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("回滚异常",e);
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
