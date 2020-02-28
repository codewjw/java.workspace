package cn.poem.exception;

public class PassWordNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6792770726760485322L;

	public PassWordNotFoundException() {
		super();
	}

	public PassWordNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PassWordNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PassWordNotFoundException(String message) {
		super(message);
	}

	public PassWordNotFoundException(Throwable cause) {
		super(cause);
	}

	
}
