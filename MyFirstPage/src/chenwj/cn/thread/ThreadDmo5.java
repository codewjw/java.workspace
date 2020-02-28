package chenwj.cn.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �첽����ִ�и��ģ����಻����
 * ͬ�������Ⱥ�˳���ִ��
 * 
 * ��Щҵ����Ҫ�ö���߳�ͬ�����У���ʱ����Խ����߳�join��������ɡ�
 * 
 * join��������һ���߳̽�������״̬��ֱ����ȴ�����һ���̹߳����������ټ�������
 * 
 * @author Administrator
 *
 */
public class ThreadDmo5 {

	public static boolean isFinish = false;
	public static void main(String[] args) {
		////�ֲ��ڲ����в��ɶ��徲̬���������Է����ⲿ��ľֲ�����(�������ڵı���)�����Ǳ���������final��
		//final boolean isFinish = false;
		final Thread download = new Thread(){
			public void run(){
				System.out.println("down:��ʼ����ͼƬ��...... ");
				for(int i=0;i<=100;i++){
					System.out.println("������"+i+"%");
				}
				System.out.println("���������");
				//�ֲ��ڲ����в��ɶ��徲̬���������Է����ⲿ��ľֲ�����(�������ڵı���)�����Ǳ���������final��
				isFinish = true;
			}
		};

	Thread show = new Thread(){
		public void run(){
			System.out.println("show:��ʼ��ʾͼƬ��...... ");
			/*
			 * �ȵȴ�������ɲ�����ʾͼƬ���ټ���
			 */
			try{
			/**
			 * �ֲ��ڲ���ķ����пɷ����ⲿ�����
			 * �ֲ��ڲ����в��ɶ��徲̬���������Է����ⲿ��ľֲ�����(�������ڵı���)�����Ǳ���������final��
			 */
			download.join();
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			if(!isFinish){
			  throw new RuntimeException("�ж��ˣ�");
			}
			System.out.println("show:ͼƬ��ʾ���");
		}
	};
	
	 download.start();
	 show.start();
	 
	 ThreadDmo5 td5 = new ThreadDmo5();
	 td5.flushTime();
	 
}
	/**
	 * ÿ��һ��ˢʱ��
	 */
	public void flushTime(){
		final SimpleDateFormat sdf = new SimpleDateFormat(
				"HH-mm-ss"); 
		Thread td = new Thread(){
			public void run(){
				while(true){
					System.out.println(sdf.format(new Date()));
					try{
					 	Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		};
		td.start();
	}
	
}
