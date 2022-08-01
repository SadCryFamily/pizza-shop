package com.app.pizzashop.service;

import com.app.pizzashop.dao.Order;
import com.app.pizzashop.repository.CustomerRepository;
import com.app.pizzashop.repository.OrderRepository;
import com.app.pizzashop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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

        log.info("Create order by ID: {}, PHONE: {}", id, phoneNumber);

        var customer = customerRepository.findCustomerByPhone(phoneNumber);
        Optional.ofNullable(customer).orElseThrow();

        var product = productRepository.getProductById(id);

        Order order = Order.builder()
                .customer(customer)
                .product(product).build();

        orderRepository.save(order);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    @Transactional
    public ResponseEntity deleteAnOrder(Long id, Long productId) {

        log.info("Delete order with ID: {}, PRODUCT_ID {}", id, productId);

        orderRepository.deleteOrderByCustomerIdAndProductId(id, productId);

        return new ResponseEntity(HttpStatus.OK);

    }

    @Override
    public List<Order> getAllCustomerOrders(Long id) {

        log.info("Get all customer orders with ID: {}", id);

        return orderRepository.getCustomerCart(id);

    }

}
