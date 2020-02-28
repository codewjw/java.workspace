package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
/**
 * 此类专门用于启动时，在服务器中初始化参数
 * 不负责处理业务
 * @author chenwj
 *
 */
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();
		//写context配置数据
		ServletContext sct = getServletContext();
		sct.setAttribute("count", 0);
	}
   
}
