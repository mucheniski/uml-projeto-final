package com.mucheniski.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mucheniski.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException objectNotFoundException, HttpServletRequest httpServletRequest) {
		StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), objectNotFoundException.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(standardError.getStatus()).body(standardError);
	}

}
