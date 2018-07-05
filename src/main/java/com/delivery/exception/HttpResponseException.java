package com.delivery.exception;

import org.springframework.http.HttpStatus;

public class HttpResponseException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -5505863126834709721L;

    private HttpStatus errorStatus;
    
    public HttpResponseException(Throwable e) {
        super(e);
    }
    
    public HttpResponseException(HttpStatus status) {
        this.errorStatus = status;
    }
    
    public HttpResponseException(HttpStatus status, String message) {
        super(message);
        this.errorStatus = status;
    }
    
    public void setHttpStatus(HttpStatus status) {
        this.errorStatus = status;
    }
    
    public HttpStatus getHttpStatus() {
        return errorStatus;
    }
}
