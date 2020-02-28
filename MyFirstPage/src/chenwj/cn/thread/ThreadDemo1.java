package chenwj.cn.thread;
/*
 * 线程
 * 线程用来并发执行多段代码，感官上是"同时执行"，实际上所有线程都是走走停停，
 * 这种执行现象称为并发
 * 线程有两种常用的创建方式
 * 方式一：
 * 继承Thread并重写run方法，run方法是用来定义当前线程要执行的任务代码
 * 
 * 方式二：
 * 实现Runnable接口去单独定义线程任务
 */
public class ThreadDemo1 {

	public static void main(String[] args) {
		/*Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();*/
		
	/*	MyRunnable1 mr1 = new MyRunnable1();
		MyRunnable2 mr2= new MyRunnable2();
		
		Thread td1 = new Thread(mr1);
		Thread td2 = new Thread(mr2);
		
		td1.start();
		td2.start();*/
		
		//匿名内部类实现
		
		/*Thread thd1 = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是哪个？");
				}
			}
		};
		
		Thread thd2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("我是那个查水表的！");
				}
			}
		});
		
		thd1.start();
		thd2.start();*/
		
		
		//获取当前正在运行的线程
		Thread tr1 = Thread.currentThread();
		System.out.println(tr1);
		dosome();
		
		
		Thread tr2 = new Thread(){
			public void run(){
				Thread t3 = Thread.currentThread();
				System.out.println("new Thread:"+t3);
				dosome();
			}
		};
		tr2.start();
		
	}

	public static void dosome(){
		Thread t = Thread.currentThread();
		System.out.println("dosome:"+t);
	}
}

/**
 * 继承线程重写run方法这样的做法有两个不足：
 * 1：由于Java是单继承的，这就导致继承了Thread就不能继承其它类
 * 2：由于重写run方法将线程的任务定义在了线程当中，这就导致线程的重用线
 * 变得很差。线程与任务不应有必然的耦合关系
 * @author Administrator
 *
 */
class Thread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}
class Thread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("我是查水表的");
		}
	}
}

class MyRunnable1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("你是谁啊？");
		}
	}
}

/**
 * 实现Runnable接口
 */
class MyRunnable2 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("I am 查水表的！");
		}
	}
}