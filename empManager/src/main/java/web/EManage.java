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
 * HttpServlet�ĸ���ʵ�������л��ӿ�
 * ��ˣ���Ҳ����javabean �淶
 */
public class EManage extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		  //1.���ղ���
		  //2.����ҵ��
		  EmpDao ed = new EmpDao();
		  List<Emp> emps = ed.findAll();
		 //3.������Ӧ
		  res.setContentType("text/html;charset=utf-8");
		  PrintWriter pw = res.getWriter();
		  //��ǰ:empManager/em
		  //Ŀ�꣺empManager/addEmp.html
		  pw.println("<a href='addEmp.html'>����</a>");
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
