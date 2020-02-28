package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class NullDemo {

	public static void main(String[] args) {
		NullDemo nd = new NullDemo();
		/**
		 * java就近调用原则，先调用子类，但不能同时有两个相同子类出现，出现了，它不知道就近谁
		 * 如下Collection和String均是Object子类,它变不能进行就近匹配了
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
