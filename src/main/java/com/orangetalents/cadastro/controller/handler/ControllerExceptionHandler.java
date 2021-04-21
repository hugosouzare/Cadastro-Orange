package com.orangetalents.cadastro.controller.handler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.orangetalents.cadastro.exceptions.BadRequestException;
import com.orangetalents.cadastro.exceptions.ObjectNotFoundException;

import feign.FeignException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request) {

		StandardError er = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> invalidInput(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		StandardError er = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getLocalizedMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	@ExceptionHandler(FeignException.class)
	public ResponseEntity<StandardError> feignError(FeignException e, HttpServletRequest request) {
		
		StandardError er = new StandardError(HttpStatus.BAD_REQUEST.value(), "Por favor, digite um CEP válido no formato de 8 números ex: 01153000",
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
	}
	
	   @ExceptionHandler(ObjectNotFoundException.class)
      public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError er = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
	}
}
