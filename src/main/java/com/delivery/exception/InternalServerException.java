package com.delivery.exception;

public class InternalServerException extends CatalogException {
    /**
     * 
     */
    private static final long serialVersionUID = -5761039391904757942L;

    public InternalServerException(ErrorCode errCode) {
        super(errCode);
        // TODO Auto-generated constructor stub
    }
    
    public InternalServerException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }
    
    public InternalServerException(Throwable e) {
        super(e);
    }
}
