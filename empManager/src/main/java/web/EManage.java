package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;
/*
 * HttpServlet的父类实现了序列化接口
 * 因此，它也满足javabean 规范
 */
public class EManage extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		  //1.接收参数
		  //2.处理业务
		  EmpDao ed = new EmpDao();
		  List<Emp> emps = ed.findAll();
		 //3.发送响应
		  res.setContentType("text/html;charset=utf-8");
		  PrintWriter pw = res.getWriter();
		  //当前:empManager/em
		  //目标：empManager/addEmp.html
		  pw.println("<a href='addEmp.html'>增加</a>");
		  pw.println("<table border='1' cellspacing='0' width='30%'>");
		  for(Emp emp:emps){
			  pw.println(" <tr>");
			  pw.println("   <td>"+emp.getEmpno());
			  pw.println("   </td>");
			  pw.println("   <td>"+emp.getName());
			  pw.println("   </td>");
			  pw.println("   <td>"+emp.getGender());
			  pw.println("   </td>");
			  pw.println("   <td>"+emp.getAge());
			  pw.println("   </td>");
			  pw.println("   <td>"+emp.getSalary());
			  pw.println("   </td>");
			  pw.println("   <td>"+emp.getDeptno());
			  pw.println("   </td>");
			  pw.println(" </tr>");
		  }
		  pw.println("</table>");
		  pw.close();
	}

}
