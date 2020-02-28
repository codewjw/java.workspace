package chenwj.cn.com;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * java.util.Map
 *���ұ�
 *�Լ�ֵkey-value�Ե���ʽ�洢Ԫ��
 *����ʵ���ࣺjava.util.HashMap(��ɢ���㷨ʵ�ֵ�Map)
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
		 * ��������һ���ֵ�Դ���Map��
		 * ����MapҪ��Key���ظ�������Map���Ѿ����ڵ�Key�洢��Ԫ��
		 * �����滻Value��������ôput�������ص�ֵ���Ǳ��滻��value�����򷵻�null
		 * Map�ж�Key�Ƿ��ظ�����Key�����equels�����ȽϵĽ����Ϊtrue����Ϊ�ظ�
		 */
	    Integer num1 = map.put("����", 98); //����ֵ����Ϊ�գ����������շ���ֵ
	    Integer num2 = map.put("��ѧ", 99);
	    Integer num3 = map.put("Ӣ��", 75);
	    Integer num4 = map.put("����", 96);
	    Integer num5 = map.put("��ѧ", 93);
	    Integer num6 = map.put("˼Ʒ", 96);
	    
	    System.out.println(num1+","+num2);
	    System.out.println(map);
	    
	    Integer num7 = map.put("����", 96);
	    System.out.println(num7);
	    System.out.println(map);
	    
	    /*
	     * ȡֵ V get(K k)
	     */
	    int k_v = map.get("����");
	    System.out.println(k_v);
	    System.out.println(map);
	    
	    /*
	     * ɾ�� V Remove(K k),���ݸ�����Key��ɾ��Map�ж�Ӧ�ļ�ֵ��
	     * ����ɾ���ļ�ֵ�Ե�ֵ
	     */
	    
	    k_v = map.remove("����");
	    System.out.println(k_v);
	    System.out.println(map);
	}
	
	/*
	 * Map���������ַ�ʽ
	 * �������е�Key,�������е�Value������ÿһ���ֵ��
	 * ���б������е�value��Բ�����
	 */
	public void mapTraverse(){
		Map<String,Integer> map = new HashMap<String,Integer>();
		   Integer num1 = map.put("����", 98); //����ֵ����Ϊ�գ����������շ���ֵ
		   Integer num2 = map.put("��ѧ", 99);
		   Integer num3 = map.put("Ӣ��", 75);
		   Integer num4 = map.put("����", 96);
		   Integer num5 = map.put("��ѧ", 93);
		   Integer num6 = map.put("˼Ʒ", 96);
		   System.out.println(map);
		   
		   /*
		    * �������е�key
		    * Set<K> keySet()
		    * �÷�������ǰMap�����е�key���뵽һ��Set���Ϻ��䷵��
		    * ���Ա������Set���Ͼ��൱�ڱ��������е�key
		    */
		   Set<String> keySet = map.keySet();
		   
		   for(String key : keySet){
			   System.out.println(key);
		   }
		   /*
		    * ����Map�е�ÿһ���ֵ��
		    * Map��һ���ڲ���Entry����ÿһ��ʵ�����ڱ�ʾMap�е�һ���ֵ��
		    * 
		    * Set<Entry> entrySet()
		    * �÷����Ὣ��ǰMap��ÿһ���ֵ��(����Entryʵ��)
		    * ���뵽Set�����з���
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
		    * �������е�Value
		    * Collection<V> values
		    * ����ǰMap�����е�value����һ�������Ϻ󷵻�
		    */
		   Collection<Integer> values = map.values();
		   for(Integer v : values){
			   System.out.println(v);
		   }
	}
}
