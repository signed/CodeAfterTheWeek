package com.github.signed.codeoftheweek.validator;

public enum Severity implements Comparable<Severity> {
	WARNING(50, "warning"), ERROR(100, "error");
	private final int ordinal;
	private final String name;

	Severity(int anOrdinal, String aName) {
		ordinal = anOrdinal;
		name = aName;
	}

	@Override
	public String toString() {
		return name;
	}
}
