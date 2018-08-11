package com.utils;

public class LogicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LogicException() {
		super();
	}

	public LogicException(String msg) {
		super(msg);
	}

	public LogicException(Throwable t) {
		super(t);
	}

	public LogicException(String msg, Throwable t) {
		super(msg, t);
	}

}
