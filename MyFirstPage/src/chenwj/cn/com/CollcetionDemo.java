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
		  * contains(Object o)�жϼ����Ƿ����Ԫ��o������������д���һ��equels��o�����Ϊtrue��˵������
		  */
		 boolean flag=c.contains(p);
		 System.out.println(flag);
		 /**
		  * remove(Object o)�Ƴ�������Ԫ�ش��ڵ�o���Ӽ�����ɾ����ָ��Ԫ��equelsΪtrue��Ԫ��
		  * ע�⣺ֻ��ɾ��һ�������ϻ����˳��Ƚϣ�ɾ����һ���Ƚ�equelsΪtrue��Ԫ�غ�����ֹͣɾ��
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
		 * addAll(Collection c)���������ϵ�����Ԫ����ӵ���ǰ������
		 * ��Ӻ�ǰ���Ͼͷ����ı䣬����true��ֻ�������Ԫ�أ�����true
		 */
		boolean flag = c1.addAll(c2);
		System.out.println(c1);
		
		Collection c3 = new HashSet();
		c3.add("DDK");
		c3.add("KKL");
		c3.add("php");
		c3.add("java");
		
		/**
		 * containsAll(Collection c) �ж��Ƿ�ǰ�������Ƿ�ȫ��������c�е�����Ԫ�أ�����������true�����򷵻�false
		 */
		boolean containAll = c1.containsAll(c3);
		System.out.println(containAll);
		
		/**
		 * removeAll(Collection c)ɾ����ǰ�����У�ָ�������뵱ǰ���Ϲ��е�Ԫ�أ�ֻҪ��Ԫ��ɾ��������true���򣬷���false
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
				  * c4.remove(str),ʹ�õ������������Ϲ������ǲ���ͨ�����ϵķ���ȥ��ɾԪ�صģ����򣬵������ᱨ��
				  * �����������ṩһ��ɾ������Ԫ�صķ���remove(),���贫�������ɾ������ʹ�õ�����next������ȡ����Ԫ��
				  */
				 
				 it.remove();
			 }
			System.out.println(str);
		}
		System.out.println(c4);
	}
	
	
}
