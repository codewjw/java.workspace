package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class NullDemo {

	public static void main(String[] args) {
		NullDemo nd = new NullDemo();
		/**
		 * java�ͽ�����ԭ���ȵ������࣬������ͬʱ��������ͬ������֣������ˣ�����֪���ͽ�˭
		 * ����Collection��String����Object����,���䲻�ܽ��оͽ�ƥ����
		 */
		nd.test(null);
	}
    
	public void test(int i){
		System.out.println("int");
	}
	public void test(Collection collection){
		System.out.println("collection");
	}
	
	public void test(ArrayList arraylist){
		System.out.println("arraylist");
	}

	/*public void test(HashSet hastSet){
		System.out.println("hastSet");
	}*/
	
	public void test(Object o){
		System.out.println("object");
	}
	
	/*public void test(String str){
		System.out.println("string");
	}*/
	
}
