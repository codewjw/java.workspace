package chenwj.cn.thread;

public class ThreadDemo2 {
 public static void main(String[] args) {
	 //获取当前运行的线程
	Thread t=Thread.currentThread();
	
	//获取线程Id
	long id =  t.getId();
	System.out.println(id);
	
	//获取线程的名称
	String name = t.getName();
	System.out.println(name);
	
	//获取线程的优先级
	int priority = t.getPriority();
	System.out.println(priority);
	
	//判断线程是否处于活动状态
	boolean isAlive = t.isAlive();
	System.out.println(isAlive);
	
	//判断是否为守护线程
	boolean isDaemon = t.isDaemon();
	System.out.println(isDaemon);
	
	//判断是否被中断
    boolean isInterrupted = t.isInterrupted();
    System.out.println(isInterrupted);
}
}
