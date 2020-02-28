package chenwj.cn.com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 * 栈也可以存储一组元素，但是存取元素必须遵循先进后出的原则
 * 栈可以通过双端队列来实现，值调用一断进出对的方法就实现了栈结构
 * 通常使用栈来完成诸如"后退"功能时使用
 * @author Administrator
 *
 */
public class StackDemo {

	public static void main(String[] args) {
		StackDemo sd = new StackDemo();
		sd.stackMethod1();
	}
    public void stackMethod1(){
    	Deque<String> stack = new LinkedList<String>();
    	
    	stack.push("one");
    	stack.push("two");
    	stack.push("three");
    	stack.push("four");
    	System.out.println(stack);
    	
    	String str = stack.pop();
    	System.out.println(str);
    	System.out.println(stack);
    	
    	str = stack.peek();
    	System.out.println(str);
    	System.out.println(stack);
    	
    	
    	
    }
}
