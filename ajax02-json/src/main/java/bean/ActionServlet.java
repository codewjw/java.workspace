package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ActionServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse res) 
					throws ServletException, IOException {
		  String path = req.getServletPath();
		  Random rand = new Random();
		  if("/quoto.do".equals(path)){
			  List<Stock> stocks = new ArrayList<Stock>();
				 for(int i=0;i<4;i++){
					Stock stock = new Stock();
					stock.setCode("65978"+rand.nextInt(10));
					stock.setName("中国嘉陵"+rand.nextInt(100));
					stock.setPrice(rand.nextInt(1000));
					stocks.add(stock);
				 }
				 ObjectMapper om = new ObjectMapper();
				 String jsonStr = om.writeValueAsString(stocks);
				 res.setContentType("text/html;charset=utf-8");
				 PrintWriter pw = res.getWriter();
				 pw.println(jsonStr);
				 //由response创建的pw对象，即使不关闭，response对象消失后，也会关闭
				 pw.close();
		  }
	}
   
}
