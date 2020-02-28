package cn.tedu;

public class HelloAction {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String doHello(){
		System.out.println("HelloAction1");
		setMessage("Hi.....hero!");
		return "success";
	}
}
