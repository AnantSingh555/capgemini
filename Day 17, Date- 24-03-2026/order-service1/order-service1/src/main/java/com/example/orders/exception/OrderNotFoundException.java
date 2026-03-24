package com.example.orders.exception;

import java.time.LocalDate;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(){}
    public OrderNotFoundException(String message){
        super(message);
    }
}
