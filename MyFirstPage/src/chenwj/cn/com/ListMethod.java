package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * java.util.List
 * List是Collection的一个接口
 * List除了可重复外，还有一个特点就是有序，所以提供了
 * 一套可以下标操作元素的方法
 * 常用的实现类：
 * java.util.ArrayList:数组实现，查询更快
 * java.utilLinkedList:链表实现，增删更快，尤其是首尾增删
 * @author Administrator
 *
 */
public class ListMethod {

	public static void main(String[] args) {
		ListMethod  lm =new ListMethod();
		//lm.listGetSet();
		//lm.listRemove();
		//lm.listSubList();
		//lm.conllectionToArray();
		lm.arrayToCollection();
	}

	public void listGetSet(){
	  List<String> list = new ArrayList<String>();
	  list.add("one");
	  list.add("two");
	  list.add("three");
	  list.add("one");
	  System.out.println(list);
	  /*Iterator<String> it= list.iterator();
	  while(it.hasNext()){
		  String str = it.next();
		  System.out.println(str);
	  }*/
	  /*for(int i=0;i<list.size();i++){
		  System.out.println(list.get(i));
	  }*/
	  String oldValue = list.set(1, "2");
	  System.out.println(oldValue);
	  for(int i=0;i<list.size();i++){
		  System.out.println(list.get(i));
	  }
	}
	
	public void listRemove(){
		 List<String> list = new ArrayList<String>();
		  list.add("one");
		  list.add("two");
		  list.add("three");
		  list.add("four");
		  System.out.println(list);
		  
		  /**
		   * 指定位置增加元素
		   */
		  list.add(1, "2");
		  System.out.println(list);
		  
		  /**
		   * 删除指定位置的元素，并将删除前该位置的元素返回
		   */
		  String old = list.remove(2);
		  System.out.println(old+","+list);
	}
	
	
	public void listSubList(){
		/*List<String> list = new ArrayList<String>();
		  list.add("one");
		  list.add("two");
		  list.add("three");
		  list.add("four");
		  list.add("five");
		  list.add("six");
		  list.add("seven");
		  list.add("eight");*/
		List<Integer> list = new ArrayList<Integer>();
		 for(int i=0;i<10;i++){
			 list.add(i);
		 }
		  System.out.println(list);
		  
//		  List<String> sublist = list.subList(2, list.size());
		  List<Integer> sublist = list.subList(2, list.size());
		  System.out.println(sublist);
		  
		  for(int i=0;i<sublist.size();i++){
			  /*int num = sublist.get(i); //编译器自动拆箱((Integer)sublist.get(i)).intValue();
			  num *= 10;*/			  
			  sublist.set(i, sublist.get(i)*10);
		  }
		  System.out.println(sublist);
		  /**
		   * 对子集的修改就是对原集合对应元素的修改
		   */
		  System.out.println(list);
		  
		  /**
		   * 删除子集元素等同于删除集合元素
		   */
		  list.subList(2, 8).clear();
		  System.out.println(list);
	}
	
	/**
	 * 集合变数组
	 */
	public void conllectionToArray(){
		 Collection<String> cs = new ArrayList<String>();
		 cs.add("one");
		 cs.add("two");
		 cs.add("three");
		 cs.add("four");
		 System.out.println(cs);
		  /**
		   * 不常用
		   */
		 // Object[] ob = cs.toArray();
		 
		 String[] strs = cs.toArray(new String[cs.size()]);
		 for(String str:strs){
		  System.out.println(str);
		 }
	}
	
	/**
	 * 数组转换尾集合
	 * 使用数组的工具类Arrays的方法asList
	 * 注意：只能转换尾List集合
	 */
	public void arrayToCollection(){
		String[] array = new String[]{
			"one","two","three","four"
		};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
		
		/**
		 * 对转换后的集合进行操作，即对原数组进行操作
		 */
		list.set(1, "2");
		System.out.println(list);
		
		for(String str:array){
			System.out.println(str);
		}
		/**
		 * 从数组转换过来的集合是不能添加新元素的，否则会抛出不受支持的操作异常
		 * 因为对集合的操作即是对原数组的操作，添加元素会导致原数组扩容，从而表示
		 * 不了原数组
		 */
		//list.add("five");
		
		/*List<String> list1 = new ArrayList<String>();
		list1.addAll(list);*/
		List<String> list1 = new ArrayList<String>(list);
		System.out.println(list1);
		list1.add("five");
		System.out.println(list1);
		
	}
}
