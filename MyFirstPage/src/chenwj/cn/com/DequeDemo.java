package chenwj.cn.com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ˫�˶���Deque
 * һ���̳���Queue�Ľӿ�
 * ���˶��ɽ����Ķ���
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
