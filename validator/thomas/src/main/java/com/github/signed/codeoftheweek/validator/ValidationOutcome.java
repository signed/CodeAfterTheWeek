package com.github.signed.codeoftheweek.validator;

public interface ValidationOutcome {
    void valid();

    void invalid(Message message);
}
