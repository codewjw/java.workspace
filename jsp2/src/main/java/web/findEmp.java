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
	     
	     //�����ݰ󶨵�request��
	     req.setAttribute("emps", emps);
	     //������ת����JSP
	     //��ȡһ������ת��������������ת����ת��
	     req.getRequestDispatcher("empList.jsp").forward(req, res);
	}
   
}
