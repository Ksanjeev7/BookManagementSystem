package com.sanju.main.Exceptions;

public class BookValidationException extends BookServiceException {
	private static final long serialVersionUID = 1L;
	public BookValidationException(String message) {
		super(message);
	}
}
