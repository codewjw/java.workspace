package chenwj.cn.thread;
/**
 * �̶߳��̵߳ĵ����ǲ��ɿ��Ƶģ�����
 * �߳�ֻ�ܱ�������CPUʱ�䣬������������ȡ��
 * 
 * �̵߳��Ȼᾡ���ܵĽ�CPUʱ�����ļ����������ȣ�����
 * ����̲߳������У�������֤һ���߳�һ��������������
 * ����ͨ�������̵߳����ȼ�����CPUʱ��Ƭ����
 * �������߳����ȼ�Խ�ߵ��̣߳���ȡCPUʱ��Ƭ�����Ͷ�
 * 
 * �߳����ȼ���Ϊ10�����ֱ���1-10��ʾ
 * ����1��ͣ�5Ĭ�ϣ�10���
 * @author Administrator
 *
 */
public class ThreadDemo3 {
     public static void main(String[] args) {
		Thread min = new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("min");
				}
			}
		});
		Thread norm = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("normal");
				}
			}
		};
		
		Thread max = new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
				System.out.println("max");
				}
			}
		};
		min.setPriority(Thread.MIN_PRIORITY);
		norm.setPriority(Thread.NORM_PRIORITY);
		max.setPriority(Thread.MAX_PRIORITY);
		min.start();
		norm.start();
		max.start();
	}
}
