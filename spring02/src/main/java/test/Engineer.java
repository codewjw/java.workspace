package test;

public class Engineer {
   public Engineer(){
	   System.out.println("Engineer()");
   }

	@Override
	public String toString() {
		return "Engineer [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
   
}
