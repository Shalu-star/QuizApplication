package com.cg.exception;

public class StudentNotFoundException extends RuntimeException {
	private String msg;
public StudentNotFoundException() {
}
public StudentNotFoundException(String msg) {
	super(msg);
	this.msg = msg;
}
}
