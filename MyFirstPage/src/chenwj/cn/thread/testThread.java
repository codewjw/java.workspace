package chenwj.cn.thread;

public class testThread extends Thread implements Runnable {
	
	public void run(){
		System.out.println("I have run");
	}

	public static void main(String args[]){
		Thread t = new Thread(new testThread());
		t.start();
		Runnable t2 = new testThread();
		new Thread(t2).start();
	}
}
