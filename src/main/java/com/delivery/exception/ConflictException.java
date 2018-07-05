package com.delivery.exception;

public class ConflictException extends CatalogException {

    private static final long serialVersionUID = -371075044401184100L;

    public ConflictException(ErrorCode errCode) {
        super(errCode);
    }

    public ConflictException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }

    public ConflictException(Throwable e) {
        super(e);
    }
}
