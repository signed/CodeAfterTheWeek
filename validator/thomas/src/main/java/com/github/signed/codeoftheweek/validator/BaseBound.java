package com.github.signed.codeoftheweek.validator;

public abstract class BaseBound implements BoundBuilder{
    @Override
    public void validate(long value, final ValidationOutcome outcome) {
        if(violatesBound(value)){
            this.usage(new StringClosure() {
                @Override
                public void usage(String message) {
                    outcome.invalid(new Message(Message.SEVERITY_ERROR.toString(), message));
                }
            });
        }else{
            outcome.valid();
        }
    }

    protected void passMax(LongClosure closure){
        //do nothing
    }

    protected void passMin(LongClosure closure){
        //do nothing
    }

    protected abstract boolean violatesBound(long value);
}