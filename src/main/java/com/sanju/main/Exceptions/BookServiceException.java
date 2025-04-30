package com.sanju.main.Exceptions;

public class BookServiceException extends RuntimeException {

	private static final long serialVersionUID = 4049369462628904927L;

	public BookServiceException (String message) {
		super(message);
	}
}