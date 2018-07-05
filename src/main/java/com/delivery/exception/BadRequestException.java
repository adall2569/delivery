package com.delivery.exception;

public class BadRequestException extends CatalogException{

    private static final long serialVersionUID = 1370048071700263567L;
    
    public BadRequestException(ErrorCode errCode) {
        super(errCode);
    }

    public BadRequestException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }

    public BadRequestException(Throwable e) {
        super(e);
    }
}
