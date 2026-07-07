package com.example.PaginationExceptionHandling.error;



public class CustomerNotFound extends RuntimeException{

	public CustomerNotFound(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
