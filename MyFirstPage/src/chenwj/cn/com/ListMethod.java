package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * java.util.List
 * List��Collection��һ���ӿ�
 * List���˿��ظ��⣬����һ���ص�������������ṩ��
 * һ�׿����±����Ԫ�صķ���
 * ���õ�ʵ���ࣺ
 * java.util.ArrayList:����ʵ�֣���ѯ����
 * java.utilLinkedList:����ʵ�֣���ɾ���죬��������β��ɾ
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
		   * ָ��λ������Ԫ��
		   */
		  list.add(1, "2");
		  System.out.println(list);
		  
		  /**
		   * ɾ��ָ��λ�õ�Ԫ�أ�����ɾ��ǰ��λ�õ�Ԫ�ط���
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
			  /*int num = sublist.get(i); //�������Զ�����((Integer)sublist.get(i)).intValue();
			  num *= 10;*/			  
			  sublist.set(i, sublist.get(i)*10);
		  }
		  System.out.println(sublist);
		  /**
		   * ���Ӽ����޸ľ��Ƕ�ԭ���϶�ӦԪ�ص��޸�
		   */
		  System.out.println(list);
		  
		  /**
		   * ɾ���Ӽ�Ԫ�ص�ͬ��ɾ������Ԫ��
		   */
		  list.subList(2, 8).clear();
		  System.out.println(list);
	}
	
	/**
	 * ���ϱ�����
	 */
	public void conllectionToArray(){
		 Collection<String> cs = new ArrayList<String>();
		 cs.add("one");
		 cs.add("two");
		 cs.add("three");
		 cs.add("four");
		 System.out.println(cs);
		  /**
		   * ������
		   */
		 // Object[] ob = cs.toArray();
		 
		 String[] strs = cs.toArray(new String[cs.size()]);
		 for(String str:strs){
		  System.out.println(str);
		 }
	}
	
	/**
	 * ����ת��β����
	 * ʹ������Ĺ�����Arrays�ķ���asList
	 * ע�⣺ֻ��ת��βList����
	 */
	public void arrayToCollection(){
		String[] array = new String[]{
			"one","two","three","four"
		};
		
		List<String> list = Arrays.asList(array);
		System.out.println(list.size());
		System.out.println(list);
		
		/**
		 * ��ת����ļ��Ͻ��в���������ԭ������в���
		 */
		list.set(1, "2");
		System.out.println(list);
		
		for(String str:array){
			System.out.println(str);
		}
		/**
		 * ������ת�������ļ����ǲ��������Ԫ�صģ�������׳�����֧�ֵĲ����쳣
		 * ��Ϊ�Լ��ϵĲ������Ƕ�ԭ����Ĳ��������Ԫ�ػᵼ��ԭ�������ݣ��Ӷ���ʾ
		 * ����ԭ����
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
