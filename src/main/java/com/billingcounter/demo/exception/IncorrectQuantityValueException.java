package com.billingcounter.demo.exception;

public class IncorrectQuantityValueException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String source;
	
	public static final boolean RECOVERABLE = true;

	public IncorrectQuantityValueException(String source) {
		super();
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public static boolean isRecoverable() {
		return RECOVERABLE;
	}
	
	

}
