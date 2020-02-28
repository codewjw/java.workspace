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
		   //模拟查询学生
		   Student stu = new Student();
		   stu.setStuId(1);
		   stu.setName("张三");
		   stu.setSex("M");
		   stu.setAge(24);
		   stu.setInterests(new String[]{"足球","篮球","乒乓球"});
		   Course cur = new Course();
		   cur.setId(1);
		   cur.setName("英语");
		   cur.setDays(3);
		   stu.setCour(cur);
		   //将数据绑定到req上
		   req.setAttribute("stu", stu);
		   //转发
		   req.getRequestDispatcher("stu.jsp").forward(req, res);
	}
 
	 
}
