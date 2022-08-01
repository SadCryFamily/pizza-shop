package com.app.pizzashop.service;

import com.app.pizzashop.dao.Order;
import com.app.pizzashop.repository.CustomerRepository;
import com.app.pizzashop.repository.OrderRepository;
import com.app.pizzashop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional
    public ResponseEntity createAnOrder(Long id, String phoneNumber) {

        var customer = customerRepository.findCustomerByPhone(phoneNumber);
        Optional.ofNullable(customer).orElseThrow();

        var product = productRepository.getProductById(id);

        Order order = Order.builder()
                .customerId(customer)
                .productId(product).build();

        orderRepository.save(order);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
