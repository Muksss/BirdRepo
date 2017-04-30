package com.saltside.birds.common.exception;

/**
 * Created by mukesh.kumar1 on 06/11/16.
 */
public class BirdException extends Exception {
    private int errorCode;

    public BirdException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BirdException(String message) {
        super(message);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
