package chenwj.cn.thread;

/**
 * 互斥锁
 * 当synchronized修饰多段不同代码，但是锁对象相同时，这些代码间
 * 具有互斥性，即：多个线程不能同时执行这些代码,例如：一个类中有两个方法有同步锁synchronized
 * @author Administrator
 *
 */
public class SyncDemo4 {
    public static void main(String[] args) {
    	final Boo boo = new Boo();
    	Thread t1 = new Thread(){
			public void run(){
				boo.methodA();;
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				boo.methodB();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Boo{
	public synchronized void methodA(){
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+"正在运行A方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":A方法执行完毕！");
	}
	
	public synchronized void methodB(){
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+"正在运行B方法");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":B方法执行完毕！");
	}
}