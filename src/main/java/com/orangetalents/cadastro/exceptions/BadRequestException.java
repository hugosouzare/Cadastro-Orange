package com.orangetalents.cadastro.exceptions;

public class BadRequestException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public BadRequestException(String msg) {
		super(msg);
	}
	
	public BadRequestException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public String getLocalizedMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
