package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//���������һ�����̣�
		//ֻ��post��Ч
		request.setCharacterEncoding("utf-8"); 
		//1.����ҵ��
		 String username = request.getParameter("username");
		 String pwd = request.getParameter("passwd");
		 String sex = request.getParameter("sex");
		 String[] interests = request.getParameterValues("interest");
		 
		 //�������ķ���1,��post��get�����ã����ǱȽ��鷳��һ�㲻��
		/* byte[] bs = username.getBytes("iso8859-1");
		 username = new String(bs,"utf-8");*/
		 
		 //2.����ҵ��
		 System.out.println(username);
		 System.out.println(pwd);
		 System.out.println(sex);
		 for(String inter:interests){
			 System.out.println(inter);
		 }
	    
		//3.������Ӧ,��Ӧ��������
		response.setContentType("text/html;charset=utf-8");
		//��Ӧ�ı�����������
		//response.setCharacterEncoding("utf-8");
	    PrintWriter pw =response.getWriter();
	    pw.println("<p>ok!"+username+"</p>");
	    pw.close();
	}
   
}
