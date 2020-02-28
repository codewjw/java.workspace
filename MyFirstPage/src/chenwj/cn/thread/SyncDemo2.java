package chenwj.cn.thread;

/**
 * ��Ч��Сͬ����Χ���Ա�֤������ȫ��ǰ������߲���Ч��
 * ʹ��ͬ������Ը�׼ȷ��������Ҫͬ���Ĵ���Ƭ�Σ������ǽ�
 * һ�������������������������С��Сͬ����Χ
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
		System.out.println(t.getName()+":�������·�......");
		Thread.sleep(5000);
		/**
		 * ͬ����
		 * synchronized(ͬ��������){
		 *  ��Ҫͬ���� ����Ƭ��
		 * }
		 * ͬ���������Ǿ�java���κ�һ�����ʵ�����ɣ����Ǳ��뱣֤�ö������߳̿�������
		 * "ͬһ��"�ſ���
		 */
		synchronized(this){
		System.out.println(t.getName()+":�������·�......");
		Thread.sleep(5000);
		}
		
		System.out.println(t.getName()+":�����뿪......");
		
		}catch(Exception e){
			
		}
		
	}
}