package com.training.java8.exception;

public class InvalidDateFormateException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public  InvalidDateFormateException(String errMessage) {
		super("Invalid Date Format: "+errMessage);
	}
}
