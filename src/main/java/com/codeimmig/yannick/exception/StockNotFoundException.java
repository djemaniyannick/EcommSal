package com.codeimmig.yannick.exception;

public class StockNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public StockNotFoundException() {
		
	}
	public StockNotFoundException(String message) {
		super(message);
	}

}
