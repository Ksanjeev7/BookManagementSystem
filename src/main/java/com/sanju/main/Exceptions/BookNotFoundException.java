package com.sanju.main.Exceptions;

public class BookNotFoundException extends BookServiceException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(String message) {
		super(message);
	}

}
