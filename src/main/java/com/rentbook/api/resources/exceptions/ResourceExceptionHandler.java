package com.rentbook.api.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rentbook.api.services.exceptions.BookAlreadyDevolved;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest req) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource Not Found");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(BookAlreadyDevolved.class)
	public ResponseEntity<StandardError> bookAlreadyDevolved(BookAlreadyDevolved e, HttpServletRequest req) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Devolution already happened!");
		err.setMessage(e.getMessage());
		err.setPath(req.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
}
