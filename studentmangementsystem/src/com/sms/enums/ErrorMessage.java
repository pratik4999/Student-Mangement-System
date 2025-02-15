package com.sms.enums;

public enum ErrorMessage {

    STUDENT_NOT_FOUND (" Student not found!"),
    INVALID_Roll_Number("Invalid Roll Number! Please enter a valid numer."),
    INVALID_AGE("Invalid Age! Age must be a positive number."),;
	
	  private final String message;

	    ErrorMessage(String message) {
	        this.message = message;
	    }

	    public String getMessage() {
	        return message;
	    }

}
