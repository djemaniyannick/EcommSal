package com.codeimmig.yannick.exception;

public class AppUserNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AppUserNotFoundException() {
		
	}
	
public AppUserNotFoundException(String message) {
		super(message);
	}
}
