package chenwj.cn.com;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ջ
 * ջҲ���Դ洢һ��Ԫ�أ����Ǵ�ȡԪ�ر�����ѭ�Ƚ������ԭ��
 * ջ����ͨ��˫�˶�����ʵ�֣�ֵ����һ�Ͻ����Եķ�����ʵ����ջ�ṹ
 * ͨ��ʹ��ջ���������"����"����ʱʹ��
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
