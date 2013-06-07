package com.github.signed.codeoftheweek.validator;

public class Severity implements Comparable<Severity> {
    private final int ordinal;
    private final String name;

    public Severity(int ordinal, String name) {
        this.ordinal = ordinal;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Severity rhs) {
        return new Integer(this.ordinal).compareTo(new Integer(rhs.ordinal));
    }
}