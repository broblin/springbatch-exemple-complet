package com.exemple.beans;

/**
 * 
 * @author benoit
 *
 */
public class FunctionalException extends Exception {
	
	int rowNumber;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1343441679753518404L;

	public FunctionalException() {
		super();
	}

	public FunctionalException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public FunctionalException(String arg0,int rowNumber) {
		super(arg0);
		this.rowNumber = rowNumber;
	}

	public FunctionalException(Throwable arg0) {
		super(arg0);
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}
}
