package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 集合提供了一个工具类
 * java.util.Collections
 * 该类提供了很多静态方法，都是便于操作集合的方法
 * 其中sort方法用于对集合元素进行自然排序（从小到大）
 * Collections还对sort方法进行了重载，重载的方法更推荐使用
 * 它有两个优点：
 * 1.不要求元素必须实现Comparable接口，减少对代码的侵入性
 * 2.当元素已经实现了Comparable接口，如String这样的类，
 * 但其提供的比较大小规则不满足我们队排序的要求时，也可以使用着重载的
 * sort解决。该重载的sort方法要求传入待排序的集合及一个额外的比较器，
 * 使用它来比较集合元素
 * @author Administrator
 *
 */
public class CollectionSort {

	public static void main(String[] args) {
		CollectionSort cs = new CollectionSort();
//		cs.collectionSort();
//		cs.collectionSort2();
		cs.collectionSort3();
		//cs.collectionSort4();
	}
    
	public void collectionSort(){
		List<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i=0;i<10;i++){
			list.add(rand.nextInt(100));
		}
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
	}
	
	/**
	 * 按Unicode码排序
	 */
	public void collectionSort2(){
		List<String> list = new ArrayList<String>();
		list.add("admin");
		list.add("james");
		list.add("jim");
		list.add("Alice");
		list.add("Simth");
		list.add("Tom");
		list.add("kim");
		list.add("tim");
		list.add("mary");
		list.add("harry");
		System.out.println(list);
	    Collections.sort(list);
	    System.out.println(list);
	}
	
	/**
	 * 中文排序意义不大
	 */
	public void collectionSort3(){
		List<String> list = new ArrayList<String>();
		list.add("陈老师");
		list.add("苍老师");
		list.add("武藤老师");
		list.add("小泽老师");
		list.add("郭老师");
		list.add("王老师");
		System.out.println(list);
	    Collections.sort(list);
	    System.out.println(list);
	    
	    /**
	     * 重载的sort方法不要求元素实现Comparable接口，若已经实现了，
	     * 也不会根据实现了的规则进行比较大小，而是根据重载后的规则
	     */
	    //MyCompartor comp = new MyCompartor();
		Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
	    });
		System.out.println(list);
	}
	
	public void collectionSort4(){
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(9,8));
		list.add(new Point(3,4));
		list.add(new Point(5,6));
		list.add(new Point(7,3));
		list.add(new Point(6,6));
		list.add(new Point(9,10));
		list.add(new Point(1,2));
		System.out.println(list);
		/**
		 * Point中没有实现Comparable接口，无法比较，便不能排序
		 */
		Collections.sort(list);
		System.out.println(list);
	}
	
	public void collectionSort5(){
		List<Point> list = new ArrayList<Point>();
		list.add(new Point(9,8));
		list.add(new Point(3,4));
		list.add(new Point(5,6));
		list.add(new Point(7,3));
		list.add(new Point(6,6));
		list.add(new Point(9,10));
		list.add(new Point(1,2));
		System.out.println(list);
		/**
		 * Point中没有实现Comparable接口，无法比较，便不能排序
		 */
		Collections.sort(list);
		System.out.println(list);
	}
}

class MyCompartor implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.length()-o2.length();
	}
	
}
