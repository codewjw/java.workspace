package chenwj.cn.exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * 子类重写超类含有throws异常抛出声明的方法时
 * 对throws重写的原则
 */
public class ThrowsExceptionDemo {

	public static void main(String[] args) {
		
	}
	public void dosome() throws IOException,AWTException{
		
	}
}

class subException extends ThrowsExceptionDemo{
	/*
	 * 不抛出异常允许
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome(){}*/
	/*
	 *允许抛超类的部分异常
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws IOException{}*/
	
	/*
	 * 允许抛出超类方法抛出异常的子类型异常
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws FileNotFoundException{}*/
	
	/*
	 * 不允许抛出额外异常
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
/*	public void dosome() throws SQLException{}*/
	
	/*
	 * 不允许抛出超类方法抛出异常的超类异常
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws Exception{}*/
}
