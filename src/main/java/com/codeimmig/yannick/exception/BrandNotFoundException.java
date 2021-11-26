package com.codeimmig.yannick.exception;

public class BrandNotFoundException  extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BrandNotFoundException() {
		
	}
	public BrandNotFoundException(String message) {
		super(message);
	}

}
