package chenwj.cn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 线程池
 * 线程池通常用于：
 * 1.可控制线程数量
 * 2.重用线程
 * 
 */
public class TheradPoolDemo {

	public static void main(String[] args) {
		/*
		 * 创建一个线程池，每次可创建2个线程
		 */
		ExecutorService threadPool = 
				Executors.newFixedThreadPool(2);
		
		for(int i=0;i<6;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+":线程正在执行！");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
					System.out.println(t.getName()+":执行了！");
				}
			};
			/*
			 * 线程池管理执行线程，每次执行两个，
			 * 总共创建5个线程：
			 * 1.因为是单数个，所以最后可能会单独执行，
			 * 执行最后一个的时候，先执行完的那个池去执行最后一个
			 * 2.线程执行完一个在线程池中会补进一个去执行
			 * 
			 */
			threadPool.execute(runn);
			System.out.println("将任务"+i+"指派给了线程池");
		}
		//停止线程池
		/*threadPool.shutdown();*/
		threadPool.shutdownNow();
		System.out.println("线程池停止了"); 
	}
}
