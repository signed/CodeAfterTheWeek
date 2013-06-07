package com.github.signed.codeoftheweek.validator;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LongRangeValidator_OutOfBoundsTest {
    private final LongRangeValidator validator = new LongRangeValidator();
    private final ValidationOutcome outcome = mock(ValidationOutcome.class);

    @Test
    public void stateOnlyTheMinimumIfNoMaximumIsSet() throws Exception {
        validator.setMinimum(5l);

        assertThat(errorMessageFor(1), is("[error] Zahl ab 5 erwartet."));
    }

    @Test
    public void stateOnlyTheMaximumIfNoMinimumIsSet() throws Exception {
        validator.setMaximum(5l);

        assertThat(errorMessageFor(6), is("[error] Zahl bis 5 erwartet."));
    }

    @Test
    public void stateMinimumAndMaximumIfBoothAreSet() throws Exception {
        validator.setMinimum(-1l);
        validator.setMaximum(2l);

        assertThat(errorMessageFor(5), is("[error] Zahl zwischen -1 und 2 erwartet."));
    }

    private String errorMessageFor(int value) {
        validator.validate(value, outcome);
        ArgumentCaptor<Message> captor = ArgumentCaptor.forClass(Message.class);
        verify(outcome).invalid(captor.capture());
        return captor.getValue().toString();
    }
}