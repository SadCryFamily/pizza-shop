package com.app.pizzashop.service;

import com.app.pizzashop.dao.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {

    ResponseEntity createAnOrder(Long id, String phoneNumber);

}
