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

public class EmpServlet extends HttpServlet {
    /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
	//查询员工find，添加员工add
	@Override
	protected void service(HttpServletRequest 
			req, HttpServletResponse res) throws ServletException, IOException {
		 //获取访问路径并处理
		 String path = req.getServletPath();
		 if("/find.emp".equals(path)){
			  findEmp(req,res);
		 }else if("/add.emp".equals(path)){
			  addEmp(req,res);
		 }else{
			 throw new RuntimeException("查无此人");
		 }
	   
	}
    
	public void findEmp(HttpServletRequest 
			req, HttpServletResponse res) throws ServletException, IOException{
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
	
	public void addEmp(HttpServletRequest 
			req, HttpServletResponse res) throws ServletException, IOException{
		    
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
		    res.sendRedirect("find.emp");
	}
}
