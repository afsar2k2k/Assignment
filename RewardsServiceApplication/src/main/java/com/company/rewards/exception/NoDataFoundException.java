package com.company.rewards.exception;

public class NoDataFoundException extends Exception {

    private String message;

    public NoDataFoundException() {

    }

    public NoDataFoundException(String msg) {
        super(msg);
    }
}
