package com.delivery.exception;

public class PreconditionFailedException extends CatalogException {

	private static final long serialVersionUID = 2822566433761783475L;

	public PreconditionFailedException(ErrorCode errCode) {
        super(errCode);
    }

    public PreconditionFailedException(ErrorCode errCode, Throwable e) {
        super(errCode, e);
    }

    public PreconditionFailedException(Throwable e) {
        super(e);
    }

}
