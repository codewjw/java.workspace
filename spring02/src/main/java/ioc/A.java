package ioc;

public class A {
   private IB b;
   
   public void setIb(IB b) {
	System.out.println("setIb()");
	this.b = b;
   }
   
   public A(){
	   System.out.println("A()");
   }
   
   public void execute(){
	   System.out.println("execute()");
	   b.f1();
   }
   
}
