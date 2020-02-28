package bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	 
	 /*
	  * 将java对象转换成json字符串
	  */
	 public static void test1() throws JsonProcessingException{
		 Stock stock = new Stock();
		 stock.setCode("66578");
		 stock.setName("中国嘉陵");
		 stock.setPrice(7.8);
		 //使用jackson提供的api来转换
		 ObjectMapper om = new ObjectMapper();
		 String jsonStr = om.writeValueAsString(stock);
		 System.out.println(jsonStr);
	 }
	 /*
	  * 将多个java对象转换成json字符串
	  */
	 public static void test2() throws JsonProcessingException{
		 List<Stock> stocks = new ArrayList<Stock>();
		 for(int i=0;i<4;i++){
			Stock stock = new Stock();
			stock.setCode("65978"+i);
			stock.setName("中国嘉陵"+i);
			stock.setPrice(7.8+i);
			stocks.add(stock);
		 }
		 ObjectMapper om = new ObjectMapper();
		 String jsonStr = om.writeValueAsString(stocks);
		 System.out.println(jsonStr);
	 }
	 public static void main(String[] args) {
		try {
			test2();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
