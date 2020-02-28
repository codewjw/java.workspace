package chenwj.cn.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����
 * �������ڴ��һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ�Ƚ��ȳ�ԭ��
 * @author Administrator
 *
 */
public class QueueDemo {
	 public static void main(String[] args) {
		 QueueDemo qd = new QueueDemo();
		 qd.queueMethod1();
	 }
	 
	 public void queueMethod1(){
		 Queue<String> queue = new LinkedList<String>();
	     
		 queue.offer("one");
		 queue.offer("two");
		 queue.offer("three");
		 queue.offer("four");
		 queue.offer("three");
		 
		 System.out.println(queue);
		 /**
		  * E poll() �Ӷ��׻�ȡԪ�أ���ȡ�󣬶���Ԫ�ػ�ɾ��
		  */
		 String str = queue.poll();
		 System.out.println(str);
		 System.out.println(queue);
		 /**
		  * E peek() ���ö���Ԫ�أ���ȡ���Ԫ�����ڶ�����
		  */
		 str = queue.peek();
		 System.out.println(str);
		 System.out.println(queue);
		 
		 /**
		  * ��������,���ڶ���ʵ���˼��Ͻӿڣ����Կ���ʹ�õ���������
		  */
		 Iterator<String> it = queue.iterator();
		 while(it.hasNext()){
			 String st = it.next();
			 System.out.println(st);
		 }
		 System.out.println(queue);
	 }
}
