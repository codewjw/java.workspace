package chenwj.cn.thread;

/**
 * �ػ��̣߳��ֳ�Ϊ����̨�߳�
 * ʹ������ǰ̨�̲߳������������߳�Ĭ�ϴ�����������ǰ̨�̣߳�
 * ���Ϊ�ػ��߳���Ҫ��������
 * 
 * ���ǽ���ʱ������һ�㲻ͬ��
 * �����̽���ʱ�����е��������е��ػ��̶߳��ᱻǿ�ƽ�����
 * ��һ�����������е�ǰ̨�̶߳����������̾ͻ����
 * 
 */
public class ThreadDemo4 {
   public static void main(String[] args) {
	   
	   Thread rose = new Thread(){
		   public void run()
		   {
			   for(int i=0;i<5;i++){
				   System.out.println("Rose:let me go!");
				   try{
					   Thread.sleep(1000);
				   }catch(InterruptedException e){
					   e.printStackTrace();
				   }
			   }
			   System.out.println("Rose:��������������������AAAAAA......");
			   System.out.println("Rose:��ͨ......");
		   }
	   };
	   Thread jack = new Thread(){
		   public void run()
		   {
			  while(true){
				   System.out.println("jack:you jump!I jump!");
				   try{
					   Thread.sleep(1000);
				   }catch(InterruptedException e){
					   e.printStackTrace();
				   }
			   }
		   }
	   };

	   rose.start();
	   //�����ػ��̱߳������߳�����ǰ����
	   jack.setDaemon(true);
	   jack.start();
	   
	   /*System.out.println("main������");*/
	   /*
	    * ����һ��main�������
	    * ֻҪ��һ��ǰ̨�̻߳����ţ����̾Ͳ�����������̲��������ػ��߳̾Ͳ���
	    */
	   /*while(true){ }*/
  }
}
