package chenwj.cn.com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 双端队列Deque
 * 一个继承自Queue的接口
 * 两端都可进出的队列
 * @author Administrator
 *
 */
public class DequeDemo {

	public static void main(String[] args) {
		DequeDemo dd = new DequeDemo();
				dd.DequeExample();
	}
	
	public void DequeExample(){
		Deque<String> deque = new LinkedList<String>();
		deque.offer("one");
		deque.offer("two");
	    deque.offerLast("three");
	    System.out.println(deque);
	    deque.offerFirst("four");
	    System.out.println(deque);
	    String str = deque.pollLast();
	    System.out.println(deque);
	    str = deque.pollFirst();
	    System.out.println(deque);
	}
		
}
