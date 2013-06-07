package com.github.signed.codeoftheweek.validator;

class NoBounds extends BaseBound {

    @Override
    public BoundBuilder min(long min) {
        return new Min(min);
    }

    @Override
    public BoundBuilder max(long max) {
        return new Max(max);
    }

    @Override
    public void usage(StringClosure sink) {
        sink.usage("Keine Begrenzungen");
    }

    @Override
    protected boolean violatesBound(long value) {
        return false;
    }
}
