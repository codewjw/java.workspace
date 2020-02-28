package test;

public class Car {
   private Engineer e;
   
   public Car(){
	   System.out.println("Car()");
   }

	public Car(Engineer e) {
		System.out.println("Car(e)");
		this.e = e;
	}

	@Override
	public String toString() {
		return "Car [e=" + e + "]";
	}
   
}
