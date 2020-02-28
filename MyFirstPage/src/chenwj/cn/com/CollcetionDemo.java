package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class CollcetionDemo {

	public static void main(String[] args) {
		CollcetionDemo cd = new CollcetionDemo();
		//cd.collectionDemo();
		//cd.containDemo();
		cd.collectionAddAll();
	}
	
	public void collectionDemo(){
	  Collection c = new ArrayList();
	  c.add("one");
	  c.add("two");
	  c.add("three");
	  c.add("four");
	  System.out.println(c);
	  System.out.println(c.size()+","+c.isEmpty());
	  c.clear();
	  System.out.println(c.size()+","+c.isEmpty());
	}

	public void containDemo(){
		 Collection c = new ArrayList();
		 c.add(new Point(1,2));
		 c.add(new Point(3,4));
		 c.add(new Point(5,6));
		 c.add(new Point(7,8));
		 Point p = new Point(1,2);
		 System.out.println(c);
		 /**
		  * contains(Object o)判断集合是否包含元素o，即如果集合中存在一个equels（o）结果为true的说明包喊
		  */
		 boolean flag=c.contains(p);
		 System.out.println(flag);
		 /**
		  * remove(Object o)移出集合中元素存在的o，从集合中删除与指定元素equels为true的元素
		  * 注意：只会删除一个，集合会进行顺序比较，删除第一个比较equels为true的元素后立即停止删除
		  */
		 boolean de_flag = c.remove(p);
		 System.out.println(c);
	}
	
	public void collectionAddAll(){
		Collection  c1 = new ArrayList();
		c1.add("java");
		c1.add("php");
		c1.add(".net");
		
		Collection c2 = new HashSet();
		c2.add("english");
		c2.add("japanese");
		c2.add("chinese");
		c2.add("java");
		/**
		 * addAll(Collection c)将给定集合的所有元素添加到当前集合中
		 * 添加后当前集合就发生改变，返回true，只有有添加元素，返回true
		 */
		boolean flag = c1.addAll(c2);
		System.out.println(c1);
		
		Collection c3 = new HashSet();
		c3.add("DDK");
		c3.add("KKL");
		c3.add("php");
		c3.add("java");
		
		/**
		 * containsAll(Collection c) 判断是否当前集合中是否全包含集合c中的所有元素，包含，返回true，否则返回false
		 */
		boolean containAll = c1.containsAll(c3);
		System.out.println(containAll);
		
		/**
		 * removeAll(Collection c)删除当前集合中，指定集合与当前集合共有的元素，只要有元素删除，返回true否则，返回false
		 */
		boolean removeAll = c1.removeAll(c3);
		System.out.println(c1+","+removeAll);
		
		
		Collection c4 = new HashSet();
		c4.add("DDK");
		c4.add("KKL");
		c4.add("php");
		c4.add("java");
		c4.add("#");
		c4.add("c");
		c4.add("c++");
		c4.add("chinese");
		c4.add("Genel");
		c4.add("#");
		c4.add(".net");
		c4.add("vb");
		c4.add("go");
		c4.add("num");
		
		Iterator it = c4.iterator();
		String str="";
		while(it.hasNext()){
			 str = (String)it.next();
			 if("#".equals(str)){
				 /**
				  * c4.remove(str),使用迭代器遍历集合过程中是不能通过集合的方法去增删元素的，否则，迭代器会报错
				  * 迭代期自身提供一个删除集合元素的方法remove(),无需传入参数，删除的是使用迭代器next方法中取出的元素
				  */
				 
				 it.remove();
			 }
			System.out.println(str);
		}
		System.out.println(c4);
	}
	
	
}
