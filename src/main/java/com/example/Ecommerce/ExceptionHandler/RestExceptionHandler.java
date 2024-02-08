package com.example.Ecommerce.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    //Value not found
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> exceptionProductHandler(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //Id not found
    @ExceptionHandler(IdException.class)
    public ResponseEntity<ErrorResponse> exceptionIdNotFound(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(e.getMessage());
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    //Bad Request Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionBadRequest(Exception e){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Request cannot be handled due to incorrect request ");
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
