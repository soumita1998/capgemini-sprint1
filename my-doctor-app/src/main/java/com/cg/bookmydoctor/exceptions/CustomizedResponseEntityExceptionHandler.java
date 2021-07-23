package com.cg.bookmydoctor.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler 
{
	@ExceptionHandler(NotValidException.class) //handling custom exception
	public ResponseEntity<String> handleNotValid(NotValidException notValidException)
	{
		return new ResponseEntity<String>("username or password not valid",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class) //handling  exception when we want to delete an id not present
	public ResponseEntity<String> handleAllEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException)
	{
		return new ResponseEntity<String>("cannot delete since user not present",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InValidIdException.class) //handling custom exception of fetch by id, if id is not present
	public ResponseEntity<String> handleInValidIdException(InValidIdException exception)
	{
		return new ResponseEntity<String>("user of that particular id or role is not present ",HttpStatus.NOT_FOUND);
	}
}
