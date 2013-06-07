package com.github.signed.codeoftheweek.validator;

public class LongRangeValidator {

    private BoundBuilder builder = new NoBounds();

    public void setMaximum(Long maximum) {
        this.builder = this.builder.max(maximum);
    }

    public void setMinimum(Long minimum) {
        this.builder = this.builder.min(minimum);
    }

    public void validate(long value, final ValidationOutcome outcome) {
        builder.validate(value, outcome);
    }
}