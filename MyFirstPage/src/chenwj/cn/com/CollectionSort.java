package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * �����ṩ��һ��������
 * java.util.Collections
 * �����ṩ�˺ܶྲ̬���������Ǳ��ڲ������ϵķ���
 * ����sort�������ڶԼ���Ԫ�ؽ�����Ȼ���򣨴�С����
 * Collections����sort�������������أ����صķ������Ƽ�ʹ��
 * ���������ŵ㣺
 * 1.��Ҫ��Ԫ�ر���ʵ��Comparable�ӿڣ����ٶԴ����������
 * 2.��Ԫ���Ѿ�ʵ����Comparable�ӿڣ���String�������࣬
 * �����ṩ�ıȽϴ�С�����������Ƕ������Ҫ��ʱ��Ҳ����ʹ�������ص�
 * sort����������ص�sort����Ҫ���������ļ��ϼ�һ������ıȽ�����
 * ʹ�������Ƚϼ���Ԫ��
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
	 * ��Unicode������
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
	 * �����������岻��
	 */
	public void collectionSort3(){
		List<String> list = new ArrayList<String>();
		list.add("����ʦ");
		list.add("����ʦ");
		list.add("������ʦ");
		list.add("С����ʦ");
		list.add("����ʦ");
		list.add("����ʦ");
		System.out.println(list);
	    Collections.sort(list);
	    System.out.println(list);
	    
	    /**
	     * ���ص�sort������Ҫ��Ԫ��ʵ��Comparable�ӿڣ����Ѿ�ʵ���ˣ�
	     * Ҳ�������ʵ���˵Ĺ�����бȽϴ�С�����Ǹ������غ�Ĺ���
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
		 * Point��û��ʵ��Comparable�ӿڣ��޷��Ƚϣ��㲻������
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
		 * Point��û��ʵ��Comparable�ӿڣ��޷��Ƚϣ��㲻������
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
