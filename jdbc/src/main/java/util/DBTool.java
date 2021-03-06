package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBTool {
    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;
    static {
      Properties p = new Properties();
      try {
		p.load(DBTool.class.getClassLoader().getResourceAsStream("db.properties"));
		//读取四个连接参数
		driver = p.getProperty("driver");
		url = p.getProperty("url");
		user = p.getProperty("user");
		pwd = p.getProperty("pwd");
		Class.forName(driver);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("加载db.properties失败！",e);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		throw new RuntimeException("找不到驱动！",e);
	}
    }
    public static Connection getConnection() throws SQLException{
    	return DriverManager.getConnection(url, user, pwd);
    }
    
    public static void close(Connection conn){
    	try {
    		if(conn!=null){
			 conn.close();
    		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("关闭连接失败！",e);
		}
    }
	public static void main(String[] args) {
      
	}

}
