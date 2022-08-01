package com.app.pizzashop.service;

import com.app.pizzashop.dao.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    List<Order> getAllCustomerOrders(Long id);

    ResponseEntity createAnOrder(Long id, String phoneNumber);

    ResponseEntity deleteAnOrder(Long id, Long productId);

}
