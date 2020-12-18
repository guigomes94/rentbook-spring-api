package com.rentbook.api.services.exceptions;

public class BookAlreadyDevolved extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	

	public BookAlreadyDevolved(String msg) {
		super(msg);
	}

}
