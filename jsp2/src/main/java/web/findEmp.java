package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpDao;
import entity.Emp;

public class findEmp extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
			throws ServletException, IOException {
	     EmpDao ed = new EmpDao();
	     List<Emp> emps = ed.findAll();
	     
	     //将数据绑定到request上
	     req.setAttribute("emps", emps);
	     //将请求转发给JSP
	     //获取一个请求转发器，并用请求转发器转发
	     req.getRequestDispatcher("empList.jsp").forward(req, res);
	}
   
}
