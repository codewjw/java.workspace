package chenwj.cn.thread;
/**
 * 线程对线程的调度是不可控制的，即：
 * 线程只能被动分配CPU时间，而不能主动获取到
 * 
 * 线程调度会尽可能的将CPU时间分配的几率做到均匀，但是
 * 多个线程并发运行，并不保证一个线程一次这样交替运行
 * 可以通过调整线程的优先级改善CPU时间片几率
 * 理论上线程优先级越高的线程，获取CPU时间片次数就多
 * 
 * 线程优先级分为10级，分别用1-10表示
 * 其中1最低，5默认，10最高
 * @author Administrator
 *
 */
public class ThreadDemo3 {
     public static void main(String[] args) {
		Thread min = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("min");
				}
			}
		});
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("normal");
				}
			}
		};
		
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("max");
				}
			}
		};
		min.setPriority(Thread.MIN_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		min.start();
		norm.start();
		max.start();
	}
}
