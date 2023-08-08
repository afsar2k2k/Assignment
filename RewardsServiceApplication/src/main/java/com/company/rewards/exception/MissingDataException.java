package com.company.rewards.exception;

public class MissingDataException extends Exception {

    private String message;

    public MissingDataException() {

    }

    public MissingDataException(String msg) {
        super(msg);
    }
}
