package chenwj.cn.thread;
/*
 * �߳�
 * �߳���������ִ�ж�δ��룬�й�����"ͬʱִ��"��ʵ���������̶߳�������ͣͣ��
 * ����ִ�������Ϊ����
 * �߳������ֳ��õĴ�����ʽ
 * ��ʽһ��
 * �̳�Thread����дrun������run�������������嵱ǰ�߳�Ҫִ�е��������
 * 
 * ��ʽ����
 * ʵ��Runnable�ӿ�ȥ���������߳�����
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
		
		//�����ڲ���ʵ��
		
		/*Thread thd1 = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("�����ĸ���");
				}
			}
		};
		
		Thread thd2 = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("�����Ǹ���ˮ��ģ�");
				}
			}
		});
		
		thd1.start();
		thd2.start();*/
		
		
		//��ȡ��ǰ�������е��߳�
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
 * �̳��߳���дrun�����������������������㣺
 * 1������Java�ǵ��̳еģ���͵��¼̳���Thread�Ͳ��ܼ̳�������
 * 2��������дrun�������̵߳������������̵߳��У���͵����̵߳�������
 * ��úܲ�߳�������Ӧ�б�Ȼ����Ϲ�ϵ
 * @author Administrator
 *
 */
class Thread1 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭����");
		}
	}
}
class Thread2 extends Thread{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("���ǲ�ˮ���");
		}
	}
}

class MyRunnable1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("����˭����");
		}
	}
}

/**
 * ʵ��Runnable�ӿ�
 */
class MyRunnable2 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("I am ��ˮ��ģ�");
		}
	}
}