package com.microservices.orderservice.service;


import com.microservices.orderservice.model.Order;

public interface OrderService {
    public Order saveOrder(Order order);
}
