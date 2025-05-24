package com.cg.exceptional.handler;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.entities.APIError;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.TestNotFoundException;
import com.cg.exception.QuestionsNotFoundException;
import com.cg.exception.SubjectNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(SubjectNotFoundException.class)
	public ResponseEntity<APIError> handle(Exception e){
		String msg=e.getMessage();
		APIError apiError= new APIError(msg, HttpStatus.NOT_FOUND);
		ResponseEntity<APIError> respEntity= new ResponseEntity<APIError>(apiError, HttpStatus.NOT_FOUND);
		return respEntity;
		
	}
	@ExceptionHandler(QuestionsNotFoundException.class)
	public ResponseEntity<APIError> handle1(Exception e){
		String msg=e.getMessage();
		APIError apiError= new APIError(msg, HttpStatus.NOT_FOUND);
		ResponseEntity<APIError> respEntity= new ResponseEntity<APIError>(apiError, HttpStatus.NOT_FOUND);
		return respEntity;
		
	}
	@ExceptionHandler(TestNotFoundException.class)
	public ResponseEntity<APIError> handle2(Exception e){
		String msg=e.getMessage();
		APIError apiError= new APIError(msg, HttpStatus.NOT_FOUND);
		ResponseEntity<APIError> respEntity= new ResponseEntity<APIError>(apiError, HttpStatus.NOT_FOUND);
		return respEntity;
		
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<APIError> handle3(Exception e){
		String msg=e.getMessage();
		APIError apiError= new APIError(msg, HttpStatus.NOT_FOUND);
		ResponseEntity<APIError> respEntity= new ResponseEntity<APIError>(apiError, HttpStatus.NOT_FOUND);
		return respEntity;
		
	}
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<String> hander2(){
		return null;
	}
}
