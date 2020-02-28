package chenwj.cn.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *
 */
public class DateDemo {

	public static void main(String[] args) throws ParseException {
		/*Random rand = new Random();
		System.out.println(rand.nextInt(27));
		long max = Long.MAX_VALUE;
		max = max/1000/60/60/24/365;
		System.out.println(1970+max);*/
		DateDemo td = new DateDemo();
	/*	td.dateDemo();
		td.simpleDateFormat();
		td.simpleDateFormat2();*/
		td.transferDay();
		
	}
	public void dateDemo()
	{
		Date date = new Date();
		//过时方法，已经不用了
		
		//int year = date.getYear();
		long time = date.getTime();
		time =time+1000*60*60*24;
		date.setTime(time);
		System.out.println(date.toString());
	}
	public void simpleDateFormat(){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		Date date = new Date();
		String str = sdf.format(date);
		System.out.println(str);
	}
	public void simpleDateFormat2() throws ParseException{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String str = "2017年12月-12日 09时43分55秒";
		Date date = sdf.parse(str);
		System.out.println(date.toString());
	}
	
	public void transferDay() throws ParseException{
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Date nowDay = new Date();
		sdf = new  SimpleDateFormat("dd");
		long days = nowDay.getTime()-date.getTime();
		System.out.println(days/1000/60/60/24/365);
	}
}
       