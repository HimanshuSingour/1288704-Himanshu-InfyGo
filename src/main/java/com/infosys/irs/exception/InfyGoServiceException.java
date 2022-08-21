/**
 * 
 */
package com.infosys.irs.exception;

public class InfyGoServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	private String errorCode;

	public InfyGoServiceException(String code, String message) {
		super(message);
		this.errorCode = code;
	}

	public InfyGoServiceException(String message) {
		super(message);

	}
}