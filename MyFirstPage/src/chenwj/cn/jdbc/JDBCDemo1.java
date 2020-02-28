package chenwj.cn.jdbc;

import java.util.Scanner;

public class JDBCDemo1 {

	public static void main(String[] args) {
		try{
		System.out.println("请输入每页显示多少条数据：");
		Scanner scan = new Scanner(System.in);
		int pageSize = Integer.parseInt(scan.nextLine());
		System.out.println("请输入当前页为第几页：");
		int page = Integer.parseInt(scan.nextLine());
		int start = (page-1)*pageSize+1;
		int end = page * pageSize;
		String sql = "SELECT * FROM (SELECT ROWNUM AS rn,name,emp_id,deptno FROM (SELECT name,emp_id,deptno"+
		      " FROM emp ORDER BY salary DESC) WHERE ROWNUM<="+end+") t "+
			  " WHERE t.rn>="+start;
		System.out.println(sql);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
