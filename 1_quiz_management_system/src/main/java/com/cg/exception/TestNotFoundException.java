package com.cg.exception;

public class TestNotFoundException extends RuntimeException {
	private String msg;
public TestNotFoundException() {
}
public TestNotFoundException(String msg) {
	super(msg);
	this.msg = msg;
}
}
