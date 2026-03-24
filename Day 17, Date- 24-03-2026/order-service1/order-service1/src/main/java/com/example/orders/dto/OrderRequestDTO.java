package com.example.orders.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDTO {

    private Long orderId;
    @NotNull(message="Name is required")
    @Size(min=3)
    private String customerName;
    @NotNull(message="Email is required")
    @Email
    private String email;
    @NotNull(message="Product name is required")
    private String productName;
    @NotNull(message="Quantity is required")
    @Min(value=1)
    private Integer quantity;
    @NotNull(message="Quantity is required")
    @Min(value=1)
    private Double pricePerUnit;
    private Double totalAmount;

    public OrderRequestDTO(){}

    public OrderRequestDTO(String customerName, String productName, String email, Integer quantity, Double pricePerUnit, Double totalAmount) {
        this.customerName = customerName;
        this.productName = productName;
        this.email = email;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = totalAmount;
    }



}
