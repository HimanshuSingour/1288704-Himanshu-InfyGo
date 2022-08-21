/**
 * 
 */
package com.infosys.irs.exception;

public class ARSServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	private String errorCode;

	public ARSServiceException(String code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ARSServiceException(String message) {
		super(message);

	}

}