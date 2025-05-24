package com.cg.exception;

public class SubjectNotFoundException extends RuntimeException {
	private String msg;
public SubjectNotFoundException() {
}
public SubjectNotFoundException(String msg) {
	super(msg);
	this.msg = msg;
}
}
