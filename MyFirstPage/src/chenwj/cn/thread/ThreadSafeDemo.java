package chenwj.cn.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * StringBuilder不是线程安全的，而StringBuffer是线程安全的
 * 
 * List中ArrayList,LinkedList不是线程安全的
 * Set中的HashSet
 * Map中的HashMap
 * 以上都不是线程安全的
 * 可以通过集合工具类Collections将它们转换为线程安全的
 * @author Administrator
 *
 */
public class ThreadSafeDemo {

	public static void main(String[] args) {
		ThreadSafeDemo tsd = new ThreadSafeDemo();
		tsd.transferSafe1();
	}
    
   public void transferSafe1(){
	   List<String> list = new ArrayList<String>();
	   list.add("one");
	   list.add("two");
	   list.add("three");
	   
	   System.out.println(list);
	   /*
	    * 将给定集合给定为线程安全的
	    */
	   list = Collections.synchronizedList(list);
	   System.out.println(list);
	   
	   Set<String> set = new HashSet<String>(list);
	   System.out.println(set);
	  
	   /*
	    * 将给定的Set集合其转换为线程安全的
	    */
	   set = Collections.synchronizedSet(set);
	   System.out.println(set);
	   
	   Map<String,Integer> map = new HashMap<String,Integer>();
	   map.put("语文",98);
	   map.put("数学", 99);
	   map.put("英语",97);
	   System.out.println(map);
	   
	   /*
	    * 将给定的Map转换为线程安全的
	    */
	   
	   map = Collections.synchronizedMap(map);
	   System.out.println(map);
	   
	   
	  /**
	   * 就算是线程安全的集合，其操作元素的相关方法也不与遍历该集合的
	   * 迭代器互斥，所以需要自行维护互斥关系 
	   */
	   
	   
	   }
}
