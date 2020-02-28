package chenwj.cn.exception;

/**
 * 
 * @author Administrator
 *
 */
public class ThrowExceptionDemo {
	 public static void main(String[] args) {
		Person p =new Person();
		try{
		p.setAge(1000);
		System.out.println("年龄"+p.getAge());
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}
}

class Person{
	private int age;
	public int getAge() {
		return age;
	}
	/* throw关键字用于抛出异常
	 * 通常有两种情况会抛出异常：
	 * 1：当满足语法要求，但是不满足实际业务逻辑时，可以当成一个异常抛出去
	 * 2：在当前方法中出现了一个实际的异常，但是不应当在当前方法中处理该异常时，
	 * 可以将其抛出
	 * 抛出异常
	 */
	public void setAge(int age) throws Exception  {
		if(age<0||age>100){
			/*
			 * 用throw 抛出一个异常时，抛出的
			 * RuntimeException及其子类的异常，可以不用处理
			 * 但当抛出一个除RuntimeException及其子类之外的其他异常时
			 * 编译器要求必须处理该异常，若没有处理代码，则编译不通过
			 * 处理方法有两种：
			 * 1.使用try-catch捕获并处理
			 * 2.在当前方法上使用Throws声明该异常的抛出
			 */
			throw new Exception();
		/*	try{
				throw new Exception("年龄不合法");
			}catch(Exception e){
				e.printStackTrace();
			}*/
			//throw new RuntimeException("年龄不合法");
		}
		this.age = age;
	}
	
}
