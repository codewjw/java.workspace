package chenwj.cn.thread;

public class ThreadDemo2 {
 public static void main(String[] args) {
	 //��ȡ��ǰ���е��߳�
	Thread t=Thread.currentThread();
	
	//��ȡ�߳�Id
	long id =  t.getId();
	System.out.println(id);
	
	//��ȡ�̵߳�����
	String name = t.getName();
	System.out.println(name);
	
	//��ȡ�̵߳����ȼ�
	int priority = t.getPriority();
	System.out.println(priority);
	
	//�ж��߳��Ƿ��ڻ״̬
	boolean isAlive = t.isAlive();
	System.out.println(isAlive);
	
	//�ж��Ƿ�Ϊ�ػ��߳�
	boolean isDaemon = t.isDaemon();
	System.out.println(isDaemon);
	
	//�ж��Ƿ��ж�
    boolean isInterrupted = t.isInterrupted();
    System.out.println(isInterrupted);
}
}
