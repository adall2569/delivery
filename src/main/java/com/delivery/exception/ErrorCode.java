package com.delivery.exception;

public enum ErrorCode {
    // BadRequest exception - 400
    CATALOG_CANNOT_CREATE(ErrorCodeConstants.BAD_REQUEST, "catalog.notCreate",
            "Cannot register the store"),

    // Unauthorized exception - 401
    CATALOG_INVALID_TOKEN(ErrorCodeConstants.UNAUTHORIZED, "catalog.invalidToken", "Invalid access token"),

    // NotFound exception - 404
    CATALOG_CANNOT_FIND_STORE(ErrorCodeConstants.NOT_FOUND, "delivery.notFoundStore",
            "Cannot find store"), 
    
    // MethodNotAllowed exception - 405
    CATALOG_METHOD_NOT_ALLOWED(ErrorCodeConstants.METHOD_NOT_ALLOWED, "catalog.methodNotAllowd",
            "The HTTP verb is not supported by the URL endpoint used in the request"),

    // Conflict exception - 409
    CATALOG_CONFLICT(ErrorCodeConstants.CONFLICT, "catalog.conflict", "Catalog is duplicated"), 

    // Internal Error - 500
    CATALOG_INTERNAL_SERVER_ERROR(ErrorCodeConstants.INTERNAL_SERVER_ERROR, "catalog.internalServerError",
            "The server encountered an internal error or misconfiguration and was unable to complete your request. Please contact the server administrator"), 
    
    // End - 500
    CATALOG_UNKNOWN_ERROR(ErrorCodeConstants.INTERNAL_SERVER_ERROR, "catalog.unknownError", "Unknown error occurs");

    private int httpCode;
    private String code;
    private String message;

    ErrorCode(int httpCode, String code, String message) {
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}