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
	//��дtoString���������������Ϣ
	@Override
	public String toString() {
		return "Manager [computer=" + computer + "]";
	}
    
}
