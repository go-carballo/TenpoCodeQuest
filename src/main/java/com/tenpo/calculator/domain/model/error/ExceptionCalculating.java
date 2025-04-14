package com.tenpo.calculator.domain.model.error;

public class ExceptionCalculating extends RuntimeException {
	public ExceptionCalculating(String message) {
		super(message);
	}
}
