package chenwj.cn.exception;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/*
 * ������д���ຬ��throws�쳣�׳������ķ���ʱ
 * ��throws��д��ԭ��
 */
public class ThrowsExceptionDemo {

	public static void main(String[] args) {
		
	}
	public void dosome() throws IOException,AWTException{
		
	}
}

class subException extends ThrowsExceptionDemo{
	/*
	 * ���׳��쳣����
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome(){}*/
	/*
	 *�����׳���Ĳ����쳣
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws IOException{}*/
	
	/*
	 * �����׳����෽���׳��쳣���������쳣
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws FileNotFoundException{}*/
	
	/*
	 * �������׳������쳣
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
/*	public void dosome() throws SQLException{}*/
	
	/*
	 * �������׳����෽���׳��쳣�ĳ����쳣
	 * @see chenwj.cn.exception.ThrowsExceptionDemo#dosome()
	 */
	/*public void dosome() throws Exception{}*/
}
