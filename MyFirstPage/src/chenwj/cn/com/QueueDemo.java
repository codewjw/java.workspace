package chenwj.cn.com;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列
 * 队列用于存放一组元素，但是存取元素必须遵循先进先出原则
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
		  * E poll() 从队首获取元素，获取后，队首元素会删除
		  */
		 String str = queue.poll();
		 System.out.println(str);
		 System.out.println(queue);
		 /**
		  * E peek() 引用队首元素，获取后该元素仍在队列中
		  */
		 str = queue.peek();
		 System.out.println(str);
		 System.out.println(queue);
		 
		 /**
		  * 遍历队列,由于队列实现了集合接口，所以可以使用迭代器遍历
		  */
		 Iterator<String> it = queue.iterator();
		 while(it.hasNext()){
			 String st = it.next();
			 System.out.println(st);
		 }
		 System.out.println(queue);
	 }
}
