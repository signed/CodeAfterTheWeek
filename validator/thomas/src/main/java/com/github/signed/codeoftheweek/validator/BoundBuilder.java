package com.github.signed.codeoftheweek.validator;

public interface BoundBuilder {

    public static interface StringClosure{

        void usage(String message);
    }
    BoundBuilder min(long min);

    BoundBuilder max(long max);

    void usage(StringClosure sink);

    void validate(long value, ValidationOutcome outcome);
}
