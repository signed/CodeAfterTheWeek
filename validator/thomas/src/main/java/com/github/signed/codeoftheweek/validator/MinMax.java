package com.github.signed.codeoftheweek.validator;

public class MinMax extends BaseBound {

    private final long min;
    private final long max;
    private final Min minimum;
    private final Max maximum;

    public MinMax(long min, long max) {
        this.min = min;
        this.max = max;
        minimum = new Min(this.min);
        maximum = new Max(this.max);
    }

    @Override
    public BoundBuilder min(long min) {
        return new MinMax(min, this.max);
    }

    @Override
    public BoundBuilder max(long max) {
        return new MinMax(this.min, max);
    }

    @Override
    public void usage(StringClosure sink) {
        final StringBuilder builder = new StringBuilder().append("Zahl zwischen ");
        minimum.passMin(new AppendToBuilder(builder));
        builder.append(" und ");
        maximum.passMax(new AppendToBuilder(builder));
        builder.append(" erwartet.");
        sink.usage(builder.toString());
    }

    @Override
    protected boolean violatesBound(long value) {
        return minimum.violatesBound(value) || maximum.violatesBound(value);
    }

    @Override
    protected void passMax(LongClosure closure) {
        maximum.passMax(closure);
    }

    @Override
    protected void passMin(LongClosure closure) {
        minimum.passMin(closure);
    }

    private static class AppendToBuilder implements LongClosure {
        private final StringBuilder builder;

        public AppendToBuilder(StringBuilder builder) {
            this.builder = builder;
        }

        @Override
        public void consume(long value) {
            builder.append(value);
        }
    }
}