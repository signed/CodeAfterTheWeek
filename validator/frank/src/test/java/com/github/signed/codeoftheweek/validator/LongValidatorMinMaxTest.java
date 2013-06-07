package com.github.signed.codeoftheweek.validator;

import org.junit.Test;

public class LongValidatorMinMaxTest {

    @Test
    public void isValid() throws Exception {
        LongValidator validator = new LongValidator.MinMax();
        validator.validate(7);
    }

    @Test
    public void boundsValid() throws Exception {
        LongValidator validator = new LongValidator.MinMax(7L, 8L);

        validator.validate(7);
    }

    @Test(expected = ValidatorException.class)
    public void maximumTooLow() throws Exception {
        LongValidator validator = new LongValidator.MinMax(15L, null);

        validator.validate(7);
    }

    @Test
    public void maximumValid() throws Exception {
        LongValidator validator = new LongValidator.MinMax(null, 8L);

        validator.validate(7);
    }

    @Test
    public void minimum() throws Exception {
        LongValidator validator = new LongValidator.MinMax(7L, null);

        validator.validate(7);
    }

    @Test(expected = ValidatorException.class)
    public void invalidMinimum() throws Exception {
        LongValidator validator = new LongValidator.MinMax(8L, null);

        validator.validate(7);
    }
}
