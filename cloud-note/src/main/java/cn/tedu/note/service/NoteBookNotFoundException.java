package cn.tedu.note.service;

public class NoteBookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4121347639900443885L;

	public NoteBookNotFoundException() {	
	}

	public NoteBookNotFoundException(String message) {
		super(message);
	}

	public NoteBookNotFoundException(Throwable cause) {
		super(cause);
	}

	public NoteBookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoteBookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
