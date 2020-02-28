package chenwj.cn.exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ExceptionDemo {
	 public static void main(String[] args) {
		 ExceptionDemo ed = new ExceptionDemo();
		 //ed.tryCatchFinallyDemo();
		 ed.finallyDemo();
	}
	 public void tryCatchFinallyDemo(){
		 System.out.println("程序开始了");
		  try{
		  String str = null;
		  str = "";
		  str = "abc";
		  System.out.println(str.length());
		  System.out.println(str.charAt(1));
		  System.out.println(Integer.parseInt(str));
		  
		  /**
		   * try中异常后的代码均不会执行
		   */
		  System.out.println("!!!!!");
		  }
		  /*
		   * catch 可以写多个，针对不同异常有不同的解决手酸时
		   * 可以分别捕获这些异常并处理
		   */
		  catch(NullPointerException e){
			  //e.printStackTrace();
			  System.out.println("空指针异常");
		  }
		  catch(StringIndexOutOfBoundsException e){
			  System.out.println("字符串下标越界异常");
		  }
		  catch(NumberFormatException e){
		   System.out.println("类型转换异常");
		  }
		  /*
		   * 应该养成一个好习惯，在最后一个catch中捕获Exception，这样
		   * 不会因为一个未捕获的异常导致程序中断。
		   * 当异常之间存在父子类关系时，一定是子类异常在上先捕获，父类异常在下
		   * 后捕获
		   * 
		   */
		  catch(Exception e){
			  System.out.println(e);
		  }
		  
		  /*finally块
		   * 在异常捕获机制中，finally块是最后的一部分。它只能跟在try块之后，
		   * 或者最后一个catch之后
		   * finally可以保证该块其中的代码【必定】执行，无论try中的代码是否出现异常
		   * 通常会将无论如何都要运行的代码放在里面，比如流操作中父关闭流这个操作
		   * 
		   */
		 finally{
			System.out.println("我始终都会走的");
		  }
		  System.out.println("程序结束了");
	 }
	 
	 public void finallyDemo(){
		 BufferedReader br = null;
		 try{
		  br = new BufferedReader(
				 new InputStreamReader(
						 new FileInputStream("chenwj.txt"))
				 );
		  System.out.println("我执行了！");
		 }catch(Exception e){
			 System.out.println(e);
		 }finally {
			 if(br!=null){
				 try{
				 br.close();
				 }catch(Exception e){
					 System.out.println(e);
				 }
			 }
			 System.out.println("我始终都是要走的");
		 }
	 }
}
