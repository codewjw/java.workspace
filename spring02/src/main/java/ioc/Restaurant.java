package ioc;

public class Restaurant {
  
	private Witer w;
	
	
	public void setW(Witer w) {
		System.out.println("setW()");
		this.w = w;
	}
	public Restaurant(){
		System.out.println("Restaurant()");
	}
	public void execute(){
		System.out.println("execute");
		w.getMoney();
	}
}
