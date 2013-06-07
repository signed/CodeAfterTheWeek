package com.github.signed.codeoftheweek.validator;

public class Message {
    public static final Severity SEVERITY_ERROR = new Severity(100, "error");
    public static final Severity SEVERITY_WARNING = new Severity(50, "warning");
    private final String level;
    private final String message;

    public Message(String level, String message) {
        this.level = level;
        this.message = message;
    }



    @Override
    public String toString() {
        return "["+level+"] " + message;
    }
}