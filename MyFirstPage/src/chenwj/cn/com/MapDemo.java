package chenwj.cn.com;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * java.util.Map
 *查找表
 *以键值key-value对的形式存储元素
 *常用实现类：java.util.HashMap(由散列算法实现的Map)
 * @author Administrator
 *
 */
public class MapDemo {

	public static void main(String[] args) {
		MapDemo md = new MapDemo();
		//md.mapMethod();
		md.mapTraverse();
	}
    
	public void mapMethod(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		/**
		 * V put(K k,V v)
		 * 将给定的一组键值对存入Map中
		 * 由于Map要求Key不重复，所以Map中已经存在的Key存储新元素
		 * 则是替换Value操作，那么put方法返回的值就是被替换的value，否则返回null
		 * Map判断Key是否重复依靠Key自身的equels方法比较的结果，为true则认为重复
		 */
	    Integer num1 = map.put("语文", 98); //返回值可能为空，最好用类接收返回值
	    Integer num2 = map.put("数学", 99);
	    Integer num3 = map.put("英语", 75);
	    Integer num4 = map.put("物理", 96);
	    Integer num5 = map.put("化学", 93);
	    Integer num6 = map.put("思品", 96);
	    
	    System.out.println(num1+","+num2);
	    System.out.println(map);
	    
	    Integer num7 = map.put("语文", 96);
	    System.out.println(num7);
	    System.out.println(map);
	    
	    /*
	     * 取值 V get(K k)
	     */
	    int k_v = map.get("语文");
	    System.out.println(k_v);
	    System.out.println(map);
	    
	    /*
	     * 删除 V Remove(K k),根据给定的Key，删除Map中对应的键值对
	     * 返回删除的键值对的值
	     */
	    
	    k_v = map.remove("语文");
	    System.out.println(k_v);
	    System.out.println(map);
	}
	
	/*
	 * Map遍历有三种方式
	 * 遍历所有的Key,遍历所有的Value，遍历每一组键值对
	 * 其中遍历所有的value相对不常用
	 */
	public void mapTraverse(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		   Integer num1 = map.put("语文", 98); //返回值可能为空，最好用类接收返回值
		   Integer num2 = map.put("数学", 99);
		   Integer num3 = map.put("英语", 75);
		   Integer num4 = map.put("物理", 96);
		   Integer num5 = map.put("化学", 93);
		   Integer num6 = map.put("思品", 96);
		   System.out.println(map);
		   
		   /*
		    * 遍历所有的key
		    * Set<K> keySet()
		    * 该方法将当前Map中所有的key存入到一个Set集合后将其返回
		    * 所以遍历这个Set集合就相当于遍历了所有的key
		    */
		   Set<String> keySet = map.keySet();
		   
		   for(String key : keySet){
			   System.out.println(key);
		   }
		   /*
		    * 遍历Map中的每一组键值对
		    * Map有一个内部类Entry，其每一个实例用于表示Map中的一组键值对
		    * 
		    * Set<Entry> entrySet()
		    * 该方法会将当前Map中每一组键值对(若干Entry实例)
		    * 存入到Set集合中返回
		    */
		   Set<Entry<String,Integer>> entrySet = map.entrySet();
		   
		   for(Entry<String,Integer> entry:entrySet){
			   String key = entry.getKey();
			   Integer value = entry.getValue();
			   System.out.println(entry);
			   System.out.println("key:"+key);
			   System.out.println("value:"+value);
		   }
		   
		   /*
		    * 遍历所有的Value
		    * Collection<V> values
		    * 将当前Map中所有的value存入一个几集合后返回
		    */
		   Collection<Integer> values = map.values();
		   for(Integer v : values){
			   System.out.println(v);
		   }
	}
}
