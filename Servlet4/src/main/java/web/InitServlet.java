package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * ����ר����������ʱ���ڷ������г�ʼ������
 * ��������ҵ��
 * @author chenwj
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		//дcontext��������
		ServletContext sct = getServletContext();
		sct.setAttribute("count", 0);
	}
   
}
