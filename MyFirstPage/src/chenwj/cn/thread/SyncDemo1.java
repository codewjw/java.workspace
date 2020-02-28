package chenwj.cn.thread;

/**
 * 多线程并发安全问题
 * 当多个线程同时操作同一资源时候，会出现“抢”的情况
 * 由于多个线程切换时间不定，肯能会导致代码执行顺序出现混乱
 * 有悖于程序设计的执行顺序而出现逻辑错误，严重是可能会导致
 * 系统瘫痪
 * @author Administrator
 *
 */
public class SyncDemo1 {

	public static void main(String[] args) {
		final Table table = new Table();
		Thread t1 = new Thread(){
			public void run(){
				while(true){
					int bean = table.getBean();
					Thread.yield();
					System.out.println(Thread.currentThread()+","+bean);
				}
			}
		};
		Thread t2 = new Thread(){
		   public void run(){
			   while(true){
				   int bean = table.getBean();
				   Thread.yield();
				   System.out.println(Thread.currentThread()+","+bean);
			   }
		   }
		};
		t1.start();
		t2.start();
	}
}

class Table {
	private int bean = 20;
	
	/**
	 * 当一个方法被synchronized修饰后，该方法称为同步方法，
	 * 即：多个线程不能同时执行该方法内容
	 *
	 *在方法上使用synchronized,那么上锁的对象就是该方法所属的对象，即this
	 * @return
	 */
	//public int getBean(){
	public synchronized int  getBean(){
		if(bean==0){
			throw new RuntimeException("没有豆豆了");
		}
		//模拟线程切换
		Thread.yield();
		return bean--;
	}
}
