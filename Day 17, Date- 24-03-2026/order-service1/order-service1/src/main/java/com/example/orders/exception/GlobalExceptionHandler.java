package com.example.orders.exception;

import com.example.orders.dto.ErrorDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.query.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(value= HttpStatus.NOT_FOUND)
    public ErrorDTO handleException(OrderNotFoundException e){
        return new ErrorDTO(LocalDate.now(), e.getMessage(), HttpStatusCode.valueOf(404));
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public Map<String, List<String>> handleValidationException(MethodArgumentNotValidException e){
        List<String> errors=e.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
        Map<String,List<String>> mp=new HashMap<>();
        mp.put("errors", errors);
        return mp;
    }
    
}
