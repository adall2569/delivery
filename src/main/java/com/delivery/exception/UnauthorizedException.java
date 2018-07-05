package com.delivery.exception;

public class UnauthorizedException extends CatalogException {
    
    private static final long serialVersionUID = -3329864822400033109L;

    public UnauthorizedException(ErrorCode errCode) {
        super(errCode);
    }

    public UnauthorizedException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }
    
    public UnauthorizedException(Throwable e) {
        super(e);
    }
}
