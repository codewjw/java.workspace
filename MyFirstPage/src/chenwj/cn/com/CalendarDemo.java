package chenwj.cn.com;

import java.util.Calendar;


public class CalendarDemo {

	public static void main(String[] args) {
		CalendarDemo cd = new CalendarDemo();
		cd.calendarDemo();
	}
	public void calendarDemo(){
		 //默认表示当前系统时间
		Calendar cd = Calendar.getInstance();
		/*Calendar cd2 = new GregorianCalendar();
		int year = cd.get(Calendar.YEAR);
		int dayY = cd.get(Calendar.DAY_OF_YEAR);
		int dayM = cd.get(Calendar.DAY_OF_MONTH);
		int dayW = cd.get(Calendar.DAY_OF_WEEK);
		int month = cd.get(Calendar.MONTH)+1;
		System.out.println(year+","+dayY+","+dayM+","+dayW+","+month);
		
		int dow = cd.getActualMaximum(Calendar.DAY_OF_YEAR);
		int dom = cd.getActualMinimum(Calendar.DAY_OF_WEEK);
		System.out.println(dow+","+dom);*/
		
		//cd.set(2008, 11, 12);
		cd.set(Calendar.YEAR,2008);
		cd.set(Calendar.MONTH, Calendar.AUGUST);
		cd.set(Calendar.DAY_OF_MONTH, 20);
		cd.set(Calendar.HOUR_OF_DAY, 8);
		cd.set(Calendar.MINUTE,18);
		cd.set(Calendar.SECOND, 55);
		System.out.println(cd.getTime());
		System.out.println(cd.get(Calendar.AM));
		
		cd.add(Calendar.DAY_OF_YEAR, 100);
		System.out.println(cd.getTime());
		/**
		 * getTime()方法返回一个Date格式时间
		 */
		/*Date date = cd.getTime();
		System.out.println(date); 
	    date.setTime(145564758L);
	    cd.setTime(date);
		System.out.println(cd);
		System.out.println(cd.getTime());*/
		
		
		
		
	}

}
