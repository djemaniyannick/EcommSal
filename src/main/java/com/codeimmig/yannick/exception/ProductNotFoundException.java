package com.codeimmig.yannick.exception;

public class ProductNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(){
		
		
	}
	public ProductNotFoundException(String message) {
		super(message);
	}


}
