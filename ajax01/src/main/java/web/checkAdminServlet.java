package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class checkAdminServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {
		//��ȡ����·�����ٷ�������
	
		String path = req.getServletPath();
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		//��post������Ч������ת��
	/*	StringBuffer url = req.getRequestURL();
		String uri = req.getRequestURI();
		String pri_path = req.getContextPath();*/
	/*	System.out.println(uri);//����·��
		System.out.println(path); //����·��
		System.out.println(url); //����·��
		System.out.println(pri_path); //��Ŀ·��/ajax01*/
		if("/check.do".equals(path)){
			String adminCode = req.getParameter("adminCode");
			System.out.println(adminCode);
			if("king".equals(adminCode)){
				pw.println("���˺��Ѵ��ڣ�");
			}else{
				pw.println("���˺ŷ���Ҫ��");
			}
			pw.close();
		 }else if("/checkpwd.do".equals(path)){
			    String pwdCode = req.getParameter("passwd");
				if("123".equals(pwdCode)){
					pw.println("�����벻����Ҫ��");
				}else{
					pw.println("���������Ҫ��");
				}
				pw.close();
		 }else if("/getNum.do".equals(path)){
			 int num = (int) (Math.random()*1000);
			 pw.println(num);
			 pw.close();
		 }else if("/getFlightPrice.do".equals(path)){
			 String  flight = req.getParameter("flight");
			 if("CA2201".equals(flight)){
				pw.println("ͷ�Ȳգ���2400<br/>����գ���2200"); 
			 }else{
			    pw.println("ͷ�Ȳգ���1800<br/>����գ���1600"); 
			 }
		 }
	}

}
