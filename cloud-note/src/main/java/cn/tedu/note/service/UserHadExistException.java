package cn.tedu.note.service;

public class UserHadExistException extends RuntimeException {

	private static final long serialVersionUID = -2233594431034639645L;

	public UserHadExistException() {
	}

	public UserHadExistException(String message) {
		super(message);

	}

	public UserHadExistException(Throwable cause) {
		super(cause);
	}

	public UserHadExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserHadExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
