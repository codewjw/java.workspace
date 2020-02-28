package cn.tedu.note.aop;


public class MemberManager {
	  public static void main(String args[]){
		  int n = 2;
		  final int[] arr = {2};
		  MemberManager mm=new MemberManager();
		  mm.test(n,arr);
		  System.out.println(n);//2
		  System.out.println(arr+"],"+arr[0]);//3
	  }
	  public void test(int n,int[] arr){
		  n++;
		  arr[0]++;
		  System.out.println("MemberManager.test"+n);//3
		  System.out.println("MemberManager.test()"+arr+"],"+arr[0]);//3
	  }
	}
