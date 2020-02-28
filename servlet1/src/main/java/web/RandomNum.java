package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomNum extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
					throws ServletException, IOException {
		//super.service(request, response);
		Random rand = new Random();
		int num = rand.nextInt(100);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<!document html>");
		pw.println("<html>");
		pw.println("<head><title>Random number</title></head>");
		pw.println("<body><p>"+num+"</p></body>");
		pw.println("</html>");
		pw.close();
	}
   
}
