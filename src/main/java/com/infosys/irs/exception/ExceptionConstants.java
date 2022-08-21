package com.infosys.irs.exception;

public enum ExceptionConstants {

	PASSENGER_LIST_EMPTY("Enter passenger details to proceed with booking!!"), USER_INVALID("user.login.invalid"),
	USER_NOT_FOUND("user.not.found");

	private final String type;

	private ExceptionConstants(String type) {
		this.type = type;
	}

	public String toString() {
		return this.type;
	}
}
