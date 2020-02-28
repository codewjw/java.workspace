package cn.tedu.netctoss.service;

/*
 * 自定义应用异常，便于区分是系统异常，还是应用异常
 */
public class ApplicationException extends RuntimeException {

	public ApplicationException() {
	}

	public ApplicationException(String message) {
		super(message);
	}
   
}
