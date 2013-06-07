package com.github.signed.codeoftheweek.validator;

public class Max extends BaseBound {

    private final long max;

    public Max(long max) {
        this.max = max;
    }

    @Override
    public BoundBuilder min(long min) {
        return new MinMax(min, max);
    }

    @Override
    public BoundBuilder max(long max) {
        return new Max(max);
    }

    @Override
    public void usage(StringClosure sink) {
        sink.usage("Zahl bis " + max + " erwartet.");
    }

    @Override
    protected boolean violatesBound(long value) {
        return max < value;
    }

    @Override
    protected void passMax(LongClosure closure) {
        closure.consume(max);
    }
}