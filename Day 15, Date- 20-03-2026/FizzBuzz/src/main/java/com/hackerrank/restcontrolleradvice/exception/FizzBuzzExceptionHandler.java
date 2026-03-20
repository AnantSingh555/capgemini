package com.hackerrank.restcontrolleradvice.exception;

import com.hackerrank.restcontrolleradvice.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(FizzException.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public GlobalError handleException(FizzException e){
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

    @ResponseBody
    @ExceptionHandler(BuzzException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    public GlobalError handleException(BuzzException e){
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

    @ResponseBody
    @ExceptionHandler(FizzBuzzException.class)
    @ResponseStatus(value= HttpStatus.INSUFFICIENT_STORAGE)
    public GlobalError handleException(FizzBuzzException e){
        return new GlobalError(e.getMessage(), e.getErrorReason());
    }

}
