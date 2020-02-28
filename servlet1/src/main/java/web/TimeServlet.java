package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//super.service(request, response); //��дʱȥ�����У����ܻᵼ�±�405�Ĵ���
		//1.ʹ��request������������
		//1��������(�̶���3������)��
		System.out.println("Э������:"+request.getProtocol());
		System.out.println("����·��:"+request.getServletPath());
		System.out.println("����ʽ:"+request.getMethod());
		//2����Ϣͷ
		//�������ǰ��ռ�ֵ�Եķ�ʽ�洢
		//Enumeration��һ�������õĵ��������÷���Iterator����
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String key = e.nextElement();
			String value = request.getHeader(key);
			System.out.println(key+","+value);
		}
		//3��ʵ�����ݣ�
		//�������޷��͵�ʵ�����ݣ������ύ�����ݼ�����ʾ
		
		
		//��ȡ��������ʱ��
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(date);

       
		//2.ʹ��respose������Ӧ����
		//1��״̬�У�������ͨ���з������Զ���д
	    //2����Ϣͷ���󲿷ֵ���Ϣͷ�����ɷ�������д��ֻ��contentType�ɳ���Ա��д
		
		//��ʱ��ƴ��һ����ҳ������������
		//����������������͵���ʲô���͵����ݣ�������ͺý���
		response.setContentType("text/html");
		//����Ŀ���������
	    PrintWriter pw = response.getWriter();
	    
	    //3��ʵ�������Ƿ���������������͵ľ������ݣ������ҳ�漴��
	    pw.println("<!doctype html>");
	    pw.println("<html>");
	    pw.println("<head>this is the first servlet</head>");
	    pw.println("<body><p>"+now+"</p></body>");
	    pw.println("</html>");
	    pw.close();
	    
	    
	    
	}

}
