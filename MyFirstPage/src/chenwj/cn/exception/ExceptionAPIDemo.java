package chenwj.cn.exception;

public class ExceptionAPIDemo {

	public static void main(String[] args) {
		System.out.println("����ʼ��");
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
			//��������ջ��Ϣ�����ڶ�λ���������
			//e.printStackTrace();
			
			String message = e.getMessage();
			System.out.println(message);
			//��ȡ�쳣ԭ��
			//e.getCause();
		}
		finally {
			System.out.println("��������Ҫ�ߵ�");
		}
		System.out.println("���������");
	}

}

/**
 * �Զ����쳣
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
			throw new IllegalAgeException("���䲻�Ϸ�");
		}
		this.age = age;
	}
	
}