package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Order;
import com.app.pizzashop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ApiOperation("Create new order")
    @PostMapping("/shop/{id}")
    public ResponseEntity createAnOrder(@PathVariable("id") Long id, @RequestBody String phoneNumber) {
        return orderService.createAnOrder(id, phoneNumber);
    }

    @ApiOperation("Get all orders for customer")
    @GetMapping("/profile/{id}/cart")
    public List<Order> getAllCustomerOrders(@PathVariable("id") Long id) {
        return orderService.getAllCustomerOrders(id);
    }

    @ApiOperation("Delete order by id for customer")
    @DeleteMapping("/profile/{id}/cart")
    public ResponseEntity deleteAnOrder(@PathVariable("id") Long id, @RequestParam Long productId) {
        return orderService.deleteAnOrder(id, productId);
    }

}
