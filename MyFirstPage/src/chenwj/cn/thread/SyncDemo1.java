package chenwj.cn.thread;

/**
 * ���̲߳�����ȫ����
 * ������߳�ͬʱ����ͬһ��Դʱ�򣬻���֡����������
 * ���ڶ���߳��л�ʱ�䲻�������ܻᵼ�´���ִ��˳����ֻ���
 * ����ڳ�����Ƶ�ִ��˳��������߼����������ǿ��ܻᵼ��
 * ϵͳ̱��
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
	 * ��һ��������synchronized���κ󣬸÷�����Ϊͬ��������
	 * ��������̲߳���ͬʱִ�и÷�������
	 *
	 *�ڷ�����ʹ��synchronized,��ô�����Ķ�����Ǹ÷��������Ķ��󣬼�this
	 * @return
	 */
	//public int getBean(){
	public synchronized int  getBean(){
		if(bean==0){
			throw new RuntimeException("û�ж�����");
		}
		//ģ���߳��л�
		Thread.yield();
		return bean--;
	}
}
