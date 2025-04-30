package com.sanju.main.ExceptionHandler;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -2567964948009623547L;

	public CustomException(String message) {
		super(message);
	}
}
