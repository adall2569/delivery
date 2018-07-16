package com.delivery.exception;

public enum ErrorCode {
    // BadRequest exception - 400
    CANNOT_CREATE_STORE(ErrorCodeConstants.BAD_REQUEST, "catalog.notCreate",
            "Cannot register the store"),

    // Unauthorized exception - 401
    INVALID_TOKEN(ErrorCodeConstants.UNAUTHORIZED, "common.invalidToken", "Invalid access token"),

    // NotFound exception - 404
    CANNOT_FIND_STORE(ErrorCodeConstants.NOT_FOUND, "delivery.notFoundStore",
            "Cannot find store"),
    CANNOT_FIND_DRIVER(ErrorCodeConstants.NOT_FOUND, "driver.notFoundDriver",
            "Cannot find driver"),
    CANNOT_FIND_DELIVERY(ErrorCodeConstants.NOT_FOUND, "delivery.notFoundDeliveryInformation",
            "Cannot find information of delivery"),
    
    // MethodNotAllowed exception - 405
    METHOD_NOT_ALLOWED(ErrorCodeConstants.METHOD_NOT_ALLOWED, "common.methodNotAllowd",
            "The HTTP verb is not supported by the URL endpoint used in the request"),

    // Conflict exception - 409 
    STORE_CONFLICT_ADDRESS(ErrorCodeConstants.CONFLICT, "store.conflictAddress", "Address is duplicated"),
    DRIVER_CONFLICT_ADDRESS(ErrorCodeConstants.CONFLICT, "driver.conflictAddress", "Address is duplicated"),
    DRIVER_CONFLICT_NICK_NAME(ErrorCodeConstants.CONFLICT, "driver.conflictNickName", "Nick name is duplicated"),
    DRIVER_CONFLICT_PHONE(ErrorCodeConstants.CONFLICT, "driver.conflictPhone", "Phone is duplicated"),
    DRIVER_CONFLICT_ID_NUM(ErrorCodeConstants.CONFLICT, "driver.conflictIdNum", "ID number is duplicated"),

    // Internal Error - 500
    INTERNAL_SERVER_ERROR(ErrorCodeConstants.INTERNAL_SERVER_ERROR, "common.internalServerError",
            "The server encountered an internal error or misconfiguration and was unable to complete your request. Please contact the server administrator"), 
    
    // End - 500
    UNKNOWN_ERROR(ErrorCodeConstants.INTERNAL_SERVER_ERROR, "common.unknownError", "Unknown error occurs");

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