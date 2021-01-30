package com.training.java8.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Component
public class ErrorResponse {

	private String message;
    private LocalDateTime localDateTime;
    private List<String> details;
	
	public ErrorResponse(String message,LocalDateTime localDateTime, List<String> detail) {
        super();
        this.message = message;
        this.details = detail;
        this.localDateTime=localDateTime;
    }
 
    
    
}
