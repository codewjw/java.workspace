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
		//super.service(request, response); //重写时去掉这行，可能会导致报405的错误
		//1.使用request接收请求数据
		//1）请求行(固定有3个数据)：
		System.out.println("协议类型:"+request.getProtocol());
		System.out.println("访问路径:"+request.getServletPath());
		System.out.println("请求方式:"+request.getMethod());
		//2）消息头
		//该数据是按照键值对的方式存储
		//Enumeration是一个不常用的迭代器，用法和Iterator类似
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String key = e.nextElement();
			String value = request.getHeader(key);
			System.out.println(key+","+value);
		}
		//3）实体内容：
		//本案例无发送的实体内容，后面提交表单数据即可演示
		
		
		//获取服务器的时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String now = sdf.format(date);

       
		//2.使用respose发送响应数据
		//1）状态行：此数据通常有服务器自动填写
	    //2）消息头：大部分的消息头数据由服务器填写，只有contentType由程序员填写
		
		//将时间拼到一个网页里给浏览器返回
		//告诉浏览器向它发送的是什么类型的内容，浏览器就好解析
		response.setContentType("text/html");
		//流的目标是浏览器
	    PrintWriter pw = response.getWriter();
	    
	    //3）实体内容是服务器向浏览器发送的具体内容，下面的页面即是
	    pw.println("<!doctype html>");
	    pw.println("<html>");
	    pw.println("<head>this is the first servlet</head>");
	    pw.println("<body><p>"+now+"</p></body>");
	    pw.println("</html>");
	    pw.close();
	    
	    
	    
	}

}
