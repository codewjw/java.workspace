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
		 System.out.println("����ʼ��");
		  try{
		  String str = null;
		  str = "";
		  str = "abc";
		  System.out.println(str.length());
		  System.out.println(str.charAt(1));
		  System.out.println(Integer.parseInt(str));
		  
		  /**
		   * try���쳣��Ĵ��������ִ��
		   */
		  System.out.println("!!!!!");
		  }
		  /*
		   * catch ����д�������Բ�ͬ�쳣�в�ͬ�Ľ������ʱ
		   * ���Էֱ𲶻���Щ�쳣������
		   */
		  catch(NullPointerException e){
			  //e.printStackTrace();
			  System.out.println("��ָ���쳣");
		  }
		  catch(StringIndexOutOfBoundsException e){
			  System.out.println("�ַ����±�Խ���쳣");
		  }
		  catch(NumberFormatException e){
		   System.out.println("����ת���쳣");
		  }
		  /*
		   * Ӧ������һ����ϰ�ߣ������һ��catch�в���Exception������
		   * ������Ϊһ��δ������쳣���³����жϡ�
		   * ���쳣֮����ڸ������ϵʱ��һ���������쳣�����Ȳ��񣬸����쳣����
		   * �󲶻�
		   * 
		   */
		  catch(Exception e){
			  System.out.println(e);
		  }
		  
		  /*finally��
		   * ���쳣��������У�finally��������һ���֡���ֻ�ܸ���try��֮��
		   * �������һ��catch֮��
		   * finally���Ա�֤�ÿ����еĴ��롾�ض���ִ�У�����try�еĴ����Ƿ�����쳣
		   * ͨ���Ὣ������ζ�Ҫ���еĴ���������棬�����������и��ر����������
		   * 
		   */
		 finally{
			System.out.println("��ʼ�ն����ߵ�");
		  }
		  System.out.println("���������");
	 }
	 
	 public void finallyDemo(){
		 BufferedReader br = null;
		 try{
		  br = new BufferedReader(
				 new InputStreamReader(
						 new FileInputStream("chenwj.txt"))
				 );
		  System.out.println("��ִ���ˣ�");
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
			 System.out.println("��ʼ�ն���Ҫ�ߵ�");
		 }
	 }
}
