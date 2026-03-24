package com.example.orders.service;

import com.example.orders.dto.OrderRequestDTO;
import com.example.orders.entity.OrderEntity;
import com.example.orders.exception.OrderNotFoundException;
import com.example.orders.mapper.OrderMapper;
import com.example.orders.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository oRepo;

    @Autowired
    public OrderServiceImpl(OrderRepository oRepo) {
        this.oRepo = oRepo;
    }

    @Override
    public OrderEntity createOrder(OrderRequestDTO request) {
        OrderEntity oE= OrderMapper.toEntity(request);
        return oRepo.save(oE);
    }

    @Override
    public OrderEntity getOrderById(Long id) throws OrderNotFoundException {
        return oRepo.findById(id).orElseThrow(()->new OrderNotFoundException("Order not found"));
    }

    @Override
    public void deleteOrder(Long id) throws OrderNotFoundException{
        if(!oRepo.existsById(id)) throw new OrderNotFoundException("Order not Found");
        oRepo.deleteById(id);
    }
}
