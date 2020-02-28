package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class GenericityDemo {

	public static void main(String[] args) {
		GenericityDemo gd =new GenericityDemo();
	    gd.testGenericity();
	}
	
	public void testGenericity(){
		Collection<String> c = new ArrayList<String>();
	    c.add("one");
	    c.add("two");
	    c.add("#");
	    c.add("three");
	    c.add("four");
	    c.add("#");
	    c.add("five");
	    c.add("six");
	    System.out.println(c);
	    
	    Iterator<String> it = c.iterator();
	    while(it.hasNext()){
	    	String str = it.next();
	    	System.out.println(str);
	    }
	    
	    for(String str:c){
	    	System.out.println(str);
	    }
	    
	   
	    
	}
}
