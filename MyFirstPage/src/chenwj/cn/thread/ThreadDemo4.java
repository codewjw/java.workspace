package chenwj.cn.thread;

/**
 * 守护线程：又称为：后台线程
 * 使用上与前台线程并无区别，所有线程默认创建出来都是前台线程，
 * 想变为守护线程需要单独设置
 * 
 * 但是结束时机上有一点不同：
 * 当进程结束时，所有的正在运行的守护线程都会被强制结束，
 * 而一个进程中所有的前台线程都结束，进程就会结束
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
			   System.out.println("Rose:啊啊啊啊啊啊啊啊啊啊AAAAAA......");
			   System.out.println("Rose:扑通......");
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
	   //设置守护线程必须在线程启动前进行
	   jack.setDaemon(true);
	   jack.start();
	   
	   /*System.out.println("main结束了");*/
	   /*
	    * 制造一个main活着情况
	    * 只要有一个前台线程还活着，进程就不会结束，进程不结束，守护线程就不死
	    */
	   /*while(true){ }*/
  }
}
