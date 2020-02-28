package chenwj.cn.thread;

/**
 * ��̬����ʹ��synchronized���κ󣬸÷���һ������ͬ��Ч��
 * ��̬����ͬ��������������󣬼�Classʵ��
 * JVM�ڼ���ÿһ�����ʱ�򣬶���ʵ����һ��Class��ʵ������
 * ��ʾ����࣬����ÿ���඼����ֻ��һ��Class��ʵ��
 * ��̬�������ľ������ʵ��
 * @author Administrator
 *
 */
public class SyncDemo3 {
    public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				Foo.dosome();
			}
		};
		
		t1.start();
		t2.start();
	}
}

class Foo{
	public static synchronized void dosome(){
		Thread t=Thread.currentThread();
		System.out.println(t.getName()+"��������dosome����");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t.getName()+":dosome����ִ����ϣ�");
	}
}