package com.delivery.exception;

public class MethodNotAllowedException extends CatalogException {

    private static final long serialVersionUID = -6006960138167052474L;

    public MethodNotAllowedException(ErrorCode errCode) {
        super(errCode);
    }
    
    public MethodNotAllowedException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }
    
    public MethodNotAllowedException(Throwable e) {
        super(e);
    }
}
