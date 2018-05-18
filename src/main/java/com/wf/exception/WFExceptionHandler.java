package com.wf.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class WFExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request, HttpStatus httpStatus) {
		ErrorDetails errorDetails = new ErrorDetails(Instant.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, httpStatus);
	}
	
	
	@ExceptionHandler(WFException.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(WFException ex, WebRequest request) {
		String[] exDetail = ex.getMessage().split(",");
		ErrorDetails errorDetails = new ErrorDetails(Instant.now(), exDetail[0], request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.valueOf(Integer.parseInt(exDetail[1])));
	}
}