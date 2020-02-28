package chenwj.cn.thread;

/**
 * 有效缩小同步范围可以保证并发安全的前提下提高并发效率
 * 使用同步块可以更准确的锁定需要同步的代码片段，而不是将
 * 一个方法整体加锁，这样可以有小缩小同步范围
 * @author Administrator
 *
 */
public class SyncDemo2 {
   public static void main(String[] args) {
	final Shop shop = new Shop();
	
	Thread t1 = new Thread(){
		public void run(){
			shop.buy();
		}
	};
	Thread t2 = new Thread(){
		public void run(){
			shop.buy();
		}
	};
	
	t1.start();
	t2.start();
  }
}

class Shop{
	
	public void buy(){
		try{
		Thread t = Thread.currentThread();
		System.out.println(t.getName()+":正在挑衣服......");
		Thread.sleep(5000);
		/**
		 * 同步块
		 * synchronized(同步监视器){
		 *  需要同步的 代码片段
		 * }
		 * 同步监视器是就java中任何一个类的实例均可，但是必须保证该对象多个线程看到的是
		 * "同一个"才可以
		 */
		synchronized(this){
		System.out.println(t.getName()+":正在试衣服......");
		Thread.sleep(5000);
		}
		
		System.out.println(t.getName()+":结账离开......");
		
		}catch(Exception e){
			
		}
		
	}
}