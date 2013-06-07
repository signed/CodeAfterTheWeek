package com.github.signed.codeoftheweek.validator;

public class Min extends BaseBound {

    private final long min;

    public Min(long min) {
        this.min = min;
    }

    @Override
    public BoundBuilder min(long min) {
        return new Min(min);
    }

    @Override
    public BoundBuilder max(long max) {
        return new MinMax(this.min, max);
    }

    @Override
    public void usage(StringClosure sink) {
        sink.usage("Zahl ab " + min + " erwartet.");
    }

    @Override
    protected boolean violatesBound(long value) {
        return min > value;
    }

    @Override
    protected void passMin(LongClosure closure) {
        closure.consume(min);
    }
}
