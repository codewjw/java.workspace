package ioc;

public class Manager {
    private Computer computer;
    
	public Manager(Computer computer) {
		System.out.println("Manager(computer)");
		this.computer = computer;
	}
	public Manager() {
	  System.out.println("Manager()");
	}
	//重写toString方法，输出对象信息
	@Override
	public String toString() {
		return "Manager [computer=" + computer + "]";
	}
    
}
