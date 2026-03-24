package com.example.orders.controller;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.dto.OrderResponseDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

    private OrderService oService;

    public OrderController(OrderService oService) {
        this.oService = oService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@Valid @RequestBody OrderRequestDTO request) {
        OrderEntity oE=oService.createOrder(request);
       return new ResponseEntity<>(OrderMapper.toResponseDTO(oE), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getById(@PathVariable Long id) {
        OrderEntity oE=oService.getOrderById(id);
    	return ResponseEntity.ok(OrderMapper.toResponseDTO(oE));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
    	oService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully");
    }
}
