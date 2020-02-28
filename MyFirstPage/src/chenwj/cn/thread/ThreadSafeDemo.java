package chenwj.cn.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * StringBuilder�����̰߳�ȫ�ģ���StringBuffer���̰߳�ȫ��
 * 
 * List��ArrayList,LinkedList�����̰߳�ȫ��
 * Set�е�HashSet
 * Map�е�HashMap
 * ���϶������̰߳�ȫ��
 * ����ͨ�����Ϲ�����Collections������ת��Ϊ�̰߳�ȫ��
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
	    * ���������ϸ���Ϊ�̰߳�ȫ��
	    */
	   list = Collections.synchronizedList(list);
	   System.out.println(list);
	   
	   Set<String> set = new HashSet<String>(list);
	   System.out.println(set);
	  
	   /*
	    * ��������Set������ת��Ϊ�̰߳�ȫ��
	    */
	   set = Collections.synchronizedSet(set);
	   System.out.println(set);
	   
	   Map<String,Integer> map = new HashMap<String,Integer>();
	   map.put("����",98);
	   map.put("��ѧ", 99);
	   map.put("Ӣ��",97);
	   System.out.println(map);
	   
	   /*
	    * ��������Mapת��Ϊ�̰߳�ȫ��
	    */
	   
	   map = Collections.synchronizedMap(map);
	   System.out.println(map);
	   
	   
	  /**
	   * �������̰߳�ȫ�ļ��ϣ������Ԫ�ص���ط���Ҳ��������ü��ϵ�
	   * ���������⣬������Ҫ����ά�������ϵ 
	   */
	   
	   
	   }
}
