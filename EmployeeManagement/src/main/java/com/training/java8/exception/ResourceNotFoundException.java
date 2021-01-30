package com.training.java8.exception;

public class ResourceNotFoundException extends RuntimeException{

	public  ResourceNotFoundException() {
		super("Resource Not Found With");
	}
}
