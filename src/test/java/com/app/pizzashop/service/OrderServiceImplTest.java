package com.app.pizzashop.service;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dao.Order;
import com.app.pizzashop.dao.Product;
import com.app.pizzashop.repository.CustomerRepository;
import com.app.pizzashop.repository.OrderRepository;
import com.app.pizzashop.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private OrderService orderService;

    @Test
    public void createAnOrderTest() {

        var customer = Customer.builder()
                .id(1L)
                .firstName("Bill")
                .lastName("Hawkington")
                .phone("+38067676767")
                .regDate(new Date(02, 02, 02))
                .build();


        Mockito.when(customerRepository.findCustomerByPhone(customer.getPhone()))
                .thenReturn(customer);

        var product = Product.builder()
                .id(10L)
                .productName("test")
                .productDescription("test")
                .productPrice(300)
                .build();

        Mockito.when(productRepository.getProductById(product.getId())).thenReturn(product);

        var result = orderService.createAnOrder(customer.getId(), customer.getPhone());

        assertEquals(result.getStatusCodeValue(), new ResponseEntity(HttpStatus.OK).getStatusCodeValue());

    }

    @Test
    public void getAllCustomerOrdersTest() {

        var customer = Customer.builder()
                .id(1L)
                .firstName("Bill")
                .lastName("Hawkington")
                .phone("+38067676767")
                .regDate(new Date(02, 02, 02))
                .build();

        var product = Product.builder()
                .id(10L)
                .productName("test")
                .productDescription("test")
                .productPrice(300)
                .build();

        Order order = Order.builder()
                .customer(customer)
                .product(product).build();

        List<Order> orderList = List.of(order);

        Mockito.when(orderRepository.getCustomerCart(customer.getId()))
                .thenReturn(orderList);

        var result = orderService.getAllCustomerOrders(customer.getId());

        assertSame(result, orderList);
    }
}