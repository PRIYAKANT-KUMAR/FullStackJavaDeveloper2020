package com.bank.exception;

public class BankExceptionHandler extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private String errorMessage;

	public BankExceptionHandler(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
