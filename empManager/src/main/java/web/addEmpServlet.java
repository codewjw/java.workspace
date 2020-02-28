package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class addEmpServlet extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) throws ServletException, IOException {
		    req.setCharacterEncoding("utf-8");
		    int empno = Integer.parseInt(req.getParameter("empno"));
		    String username = req.getParameter("username");
		    String sex = req.getParameter("sex");
		    double salary = Double.parseDouble(req.getParameter("salary"));
		    int   age = Integer.parseInt(req.getParameter("age"));
		    int   deptno = Integer.parseInt(req.getParameter("deptno"));
		    Emp emp = new Emp();
		    emp.setEmpno(empno);
		    emp.setName(username);
		    emp.setGender(sex);
		    emp.setAge(age);
		    emp.setSalary(salary);
		    emp.setDeptno(deptno);
		    EmpDao ed = new EmpDao();
		    ed.save(emp);
		    
		    /*res.setContentType("text/html;charset=utf-8");
		    PrintWriter pw = res.getWriter();
		    pw.println("<p>保存成功！</p>");
		    pw.close();*/
		    
		    //重定向
		    //当前:empManager/add
		    //目标:empManager/emp
		    res.sendRedirect("emp");
	}
    
}
