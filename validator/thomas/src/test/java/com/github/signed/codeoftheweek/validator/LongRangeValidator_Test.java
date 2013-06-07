package com.github.signed.codeoftheweek.validator;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LongRangeValidator_Test {
    private final LongRangeValidator validator = new LongRangeValidator();
    private final ValidationOutcome outcome = mock(ValidationOutcome.class);

    @Test
    public void withoutBordersAnyLongValueIsValid() throws Exception {
        assertThatSevenIsValid();
    }

    @Test
    public void minimumValueIsValid() throws Exception {
        validator.setMinimum(7l);

        assertThatSevenIsValid();
    }

    @Test
    public void maximumValueIsValid() throws Exception {
        validator.setMaximum(7l);

        assertThatSevenIsValid();
    }

    @Test
    public void maximumTooLow() throws Exception {
        validator.setMinimum(15l);

        assertThatSevenIsInValid();
    }

    @Test
    public void numbersBelowTheMaximumAreValid() throws Exception {
        validator.setMaximum(8l);

        assertThatSevenIsValid();
    }

    @Test
    public void numbersBelowMinimumAreInvalid() throws Exception {
        validator.setMinimum(8l);

        assertThatSevenIsInValid();
    }

    private void assertThatSevenIsValid() {
        validateSeven();
        verify(outcome).valid();
    }

    private void assertThatSevenIsInValid() {
        validateSeven();
        verify(outcome).invalid(Mockito.any(Message.class));
    }

    private void validateSeven() {
        validator.validate(7, outcome);
    }
}