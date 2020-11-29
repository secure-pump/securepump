package com.securepump.securepump.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordAlreadyPresentException extends RuntimeException {
	public RecordAlreadyPresentException(String message) {
		super(message);
	}

}
