package com.cg.exception;


public class QuestionsNotFoundException extends RuntimeException {
	private String msg;
public QuestionsNotFoundException() {
}
public QuestionsNotFoundException(String msg) {
	super(msg);
	this.msg = msg;
}
}
