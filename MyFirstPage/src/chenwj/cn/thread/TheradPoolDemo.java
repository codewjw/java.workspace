package chenwj.cn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * �̳߳�
 * �̳߳�ͨ�����ڣ�
 * 1.�ɿ����߳�����
 * 2.�����߳�
 * 
 */
public class TheradPoolDemo {

	public static void main(String[] args) {
		/*
		 * ����һ���̳߳أ�ÿ�οɴ���2���߳�
		 */
		ExecutorService threadPool = 
				Executors.newFixedThreadPool(2);
		
		for(int i=0;i<6;i++){
			Runnable runn = new Runnable(){
				public void run(){
					Thread t = Thread.currentThread();
					System.out.println(t.getName()+":�߳�����ִ�У�");
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						//e.printStackTrace();
					}
					System.out.println(t.getName()+":ִ���ˣ�");
				}
			};
			/*
			 * �̳߳ع���ִ���̣߳�ÿ��ִ��������
			 * �ܹ�����5���̣߳�
			 * 1.��Ϊ�ǵ����������������ܻᵥ��ִ�У�
			 * ִ�����һ����ʱ����ִ������Ǹ���ȥִ�����һ��
			 * 2.�߳�ִ����һ�����̳߳��лᲹ��һ��ȥִ��
			 * 
			 */
			threadPool.execute(runn);
			System.out.println("������"+i+"ָ�ɸ����̳߳�");
		}
		//ֹͣ�̳߳�
		/*threadPool.shutdown();*/
		threadPool.shutdownNow();
		System.out.println("�̳߳�ֹͣ��"); 
	}
}
