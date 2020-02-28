package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import entity.Student;

public class queryStuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest 
			req, HttpServletResponse res) 
					throws ServletException, IOException {
		   //ģ���ѯѧ��
		   Student stu = new Student();
		   stu.setStuId(1);
		   stu.setName("����");
		   stu.setSex("M");
		   stu.setAge(24);
		   stu.setInterests(new String[]{"����","����","ƹ����"});
		   Course cur = new Course();
		   cur.setId(1);
		   cur.setName("Ӣ��");
		   cur.setDays(3);
		   stu.setCour(cur);
		   //�����ݰ󶨵�req��
		   req.setAttribute("stu", stu);
		   //ת��
		   req.getRequestDispatcher("stu.jsp").forward(req, res);
	}
 
	 
}
