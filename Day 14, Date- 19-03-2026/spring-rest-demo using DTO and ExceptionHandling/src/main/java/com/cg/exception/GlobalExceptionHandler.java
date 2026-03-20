package com.cg.exception;

import com.cg.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(EmployeeNotFoundException e, HttpServletRequest request){
        return new ErrorDTO(e.getMessage(), LocalDate.now(), request.getRequestURI());
    }
}
