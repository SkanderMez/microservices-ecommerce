package com.microservices.orderservice.controller;

import com.microservices.orderservice.feignclient.UserClient;
import com.microservices.orderservice.model.Item;
import com.microservices.orderservice.model.Order;
import com.microservices.orderservice.model.User;
import com.microservices.orderservice.service.CartService;
import com.microservices.orderservice.service.OrderService;
import com.microservices.orderservice.utilities.OrderUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private UserClient userClient;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CartService cartService;

    @PostMapping(value = "/order/{userId}")
    private ResponseEntity saveOrder(@PathVariable("userId") Long userId, @RequestHeader(value = "Cookie") String cartId){
        Order order = new Order();
        List<Item> cart = cartService.getAllItemsFromCart(cartId);
        User user = userClient.getOneUser(userId);
        order.setItems(cart);
        order.setUser(user);
        order.setTotal(OrderUtilities.countTotalPrice(cart));
        order.setOrderedDate(LocalDate.now());
        order.setStatus("PAYMENT_EXPECTED");

        try{
            orderService.saveOrder(order);
            cartService.deleteCart(cartId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity(order, HttpStatus.CREATED);
    }
}
