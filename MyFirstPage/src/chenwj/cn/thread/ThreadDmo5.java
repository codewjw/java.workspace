package chenwj.cn.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 异步：各执行各的，互相不妨碍
 * 同步：有先后顺序的执行
 * 
 * 有些业务需要让多个线程同步运行，这时候可以借助线程join方法来完成。
 * 
 * join方法允许一个线程进入阻塞状态，直到其等待的另一个线程工作结束后再继续运行
 * 
 * @author Administrator
 *
 */
public class ThreadDmo5 {

	public static boolean isFinish = false;
	public static void main(String[] args) {
		////局部内部类中不可定义静态变量，可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
		//final boolean isFinish = false;
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:开始下载图片了...... ");
				for(int i=0;i<=100;i++){
					System.out.println("下载了"+i+"%");
				}
				System.out.println("下载完成了");
				//局部内部类中不可定义静态变量，可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
				isFinish = true;
			}
		};

	Thread show = new Thread(){
		public void run(){
			System.out.println("show:开始显示图片了...... ");
			/*
			 * 先等待下载完成才能显示图片，再加载
			 */
			try{
			/**
			 * 局部内部类的方法中可访问外部类变量
			 * 局部内部类中不可定义静态变量，可以访问外部类的局部变量(即方法内的变量)，但是变量必须是final的
			 */
			download.join();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(!isFinish){
			  throw new RuntimeException("中断了！");
			}
			System.out.println("show:图片显示完成");
		}
	};
	
	 download.start();
	 show.start();
	 
	 ThreadDmo5 td5 = new ThreadDmo5();
	 td5.flushTime();
	 
}
	/**
	 * 每隔一秒刷时间
	 */
	public void flushTime(){
		final SimpleDateFormat sdf = new SimpleDateFormat(
				"HH-mm-ss"); 
		Thread td = new Thread(){
			public void run(){
				while(true){
					System.out.println(sdf.format(new Date()));
					try{
					 	Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		td.start();
	}
	
}
