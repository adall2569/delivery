package com.delivery.exception;

import java.util.HashMap;
import java.util.Map;

public class CatalogException extends RuntimeException {
    private static final long serialVersionUID = -2739156833589717194L;

    protected ErrorCode errCode = ErrorCode.CATALOG_INTERNAL_SERVER_ERROR;
    protected Map<String, Object> info = new HashMap<>();

    public CatalogException() {
    }

    public CatalogException(ErrorCode errCode) {
        this.errCode = errCode;
    }

    public CatalogException(ErrorCode errCode, Throwable e) {
        super(e);
        this.errCode = errCode;
    }

    public CatalogException(Throwable e) {
        super(e);
    }

    public int getHttpCode() {
        return errCode.getHttpCode();
    }

    public String getCode() {
        return errCode.getCode();
    }

    public String getMessage() {
        return errCode.getMessage();
    }

    public void addInformation(String key, Object value) {
        info.put(key, value);
    }

    public Map<String, Object> getInformation() {
        return info;
    }
}
