package com.github.signed.codeoftheweek.validator;

public class ValidatorException extends Exception {
	private final Severity severity;

	public ValidatorException(Severity aSeverity, String aMessage) {
		super(aMessage);

		severity = aSeverity;
	}
}
