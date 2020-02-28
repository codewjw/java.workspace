package web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		String path = req.getServletPath();
		String user = req.getParameter("user");
	    //���˺Ŵ���cookie,һ��cookie������ֻ�ܴ�һ�����ݣ�����ֻ�ܴ��ַ���
		Cookie cook = new Cookie("user",user);
		//��cookie�浽Ӳ����
		cook.setMaxAge(60*30);
		//��cookie���͸������,��cookie�󶨵�response��,
		//��������������Ӧʱ���Զ�����cookie,������ᱣ��
		res.addCookie(cook);
		
		//��������
		Cookie cook2 = new Cookie("city",
				URLEncoder.encode("����","utf-8"));
		res.addCookie(cook2);
		
		//�趨cookie����Ч·��
		Cookie cook3 = new Cookie("status","1");
		//�趨cookie��Ч·��Ϊ������Ŀ
		cook3.setPath("/jsp4");
		res.addCookie(cook3);
	}
    
}
