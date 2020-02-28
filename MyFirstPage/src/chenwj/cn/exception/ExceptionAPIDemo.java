package chenwj.cn.exception;

public class ExceptionAPIDemo {

	public static void main(String[] args) {
		System.out.println("程序开始了");
		try{
			/*String str = "abc";
			System.out.println(Integer.parseInt(str));*/
			Man man = new Man();
			man.setAge(90);
			System.out.println(man.getAge());
			
		}catch(IllegalAgeException e){
			String message = e.getMessage();
			System.out.println(message);
		}
		catch(Exception e){
			//输出错误堆栈信息，便于定位并解决错误
			//e.printStackTrace();
			
			String message = e.getMessage();
			System.out.println(message);
			//获取异常原因
			//e.getCause();
		}
		finally {
			System.out.println("我是铁定要走的");
		}
		System.out.println("程序结束了");
	}

}

/**
 * 自定义异常
 * @author Administrator
 *
 */
class IllegalAgeException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalAgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalAgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}

class Man {
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws IllegalAgeException {
		if(age<0||age>100){
			throw new IllegalAgeException("年龄不合法");
		}
		this.age = age;
	}
	
}