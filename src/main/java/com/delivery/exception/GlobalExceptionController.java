package com.delivery.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.delivery.dto.ResponseData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionController {
    
    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseData handleBadRequest(HttpServletRequest request, BadRequestException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
    }
    
    @ExceptionHandler(value = MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ResponseData handleMethodNotAllowed(HttpServletRequest request, MethodNotAllowedException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
    }
    
    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseData handleNotFound(HttpServletRequest request, NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
    }
    
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseData handleUnauthorized(HttpServletRequest request, UnauthorizedException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
    }
    
    @ExceptionHandler(value = ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseData handleConflict(HttpServletRequest request, ConflictException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
    }

    @ExceptionHandler(value = CatalogException.class)
    @ResponseBody
    public ResponseEntity<?> handleCatalogException(HttpServletRequest request, CatalogException ex) {
        
        log.error(ex.getMessage(), ex);
        
        ResponseData retData = new ResponseData(ex.getCode(), ex.getMessage(), ex.getInformation());
        
        return new ResponseEntity<>(retData, HttpStatus.valueOf(ex.getHttpCode()));
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseData handleThrowable(HttpServletRequest request, Throwable ex) {
        log.error(ex.getMessage(), ex);
        ResponseData rData = new ResponseData(ErrorCode.CATALOG_INTERNAL_SERVER_ERROR.getCode(), ex.getMessage(), null);
        return rData;
    }
}
