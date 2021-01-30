package com.training.java8.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler	 {

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

			List<String> errorList=new ArrayList<>();
			for(ObjectError err: ex.getBindingResult().getAllErrors()) {
				errorList.add(err.getDefaultMessage());
				System.out.println(err.getDefaultMessage());
			}
			
			LocalDateTime currdateTime=LocalDateTime.now();
			String message="Validation Failed";
			ErrorResponse errRes=new ErrorResponse(message,currdateTime,errorList);
			//System.out.println(errRes);
			
			return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(value = { InvalidDateFormateException.class })
	protected ResponseEntity<Object> handleInvalidDateFormateException(InvalidDateFormateException ex,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {

		List<String> errorList=new ArrayList<>();
		
		errorList.add(ex.getLocalizedMessage());
		
		
		LocalDateTime currdateTime=LocalDateTime.now();
		String message="Invalid Date Format";
		ErrorResponse errRes=new ErrorResponse(message,currdateTime,errorList);
		
		return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
}
	
	 
	 
	
}
