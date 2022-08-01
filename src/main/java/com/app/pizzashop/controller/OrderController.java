package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Order;
import com.app.pizzashop.repository.OrderRepository;
import com.app.pizzashop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/shop/{id}")
    public ResponseEntity createAnOrder(@PathVariable("id") Long id, @RequestBody String phoneNumber) {
        return orderService.createAnOrder(id, phoneNumber);
    }

    @GetMapping("/profile/{id}/cart")
    public List<Order> getAllCustomerOrders(@PathVariable("id") Long id) {
        return orderRepository.getCustomerCart(id);
    }

}
