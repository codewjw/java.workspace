package chenwj.cn.com;

import java.util.ArrayList;
import java.util.Collection;

public class PointTest {
  public static void main(String[] args) {
//	  Collection<PointDemo>  c = new ArrayList<PointDemo>();
	  PointTest pt = new PointTest();
	 // pt.testDemo();
	  pt.genericity();
	   
 }
  
  public void testDemo(){
	  PointDemo<Integer> pd1 = new PointDemo<Integer>(3,5);
	  int k = pd1.getX();
	  int j = pd1.getY();
	  
	  System.out.println(k+","+j);
	  
	  
	  PointDemo<Double> pd2 = new PointDemo<Double>(3.11,3.22);
	  double m = pd2.getX();
	  double n = pd2.getY();
	  
	  System.out.println(m+","+n);
	  
	  PointDemo<String> pd3 = new PointDemo<String>("Hello","World");
	  String a = pd3.getX();
	  String b = pd3.getY();
	  
	  System.out.println(a+","+b);
  }
  
  public void genericity(){
	  PointDemo<Integer> pd1 = new PointDemo<Integer>(3,5);
	  int k = pd1.getX();
	  int j = pd1.getY();
	  System.out.println(k+","+j);
	  pd1.setX(5);
	  
	  /**
	   * 编译器会自动拆箱
	   * ((Integer)pd1.getX()).intValue()
	   */
	  k = pd1.getX();
	  System.out.println(k+","+j);
	  
	  PointDemo pd2 = pd1;
	  pd2.setX("五");
	  System.out.println(pd2.getX());
	  
	 /* k =  (Integer)pd2.getX(); //类型转换错误
	  System.out.println(k);*/
	  
	  
  }
}
