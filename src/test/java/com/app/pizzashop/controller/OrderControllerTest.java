package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dao.Order;
import com.app.pizzashop.dao.Product;
import com.app.pizzashop.service.OrderService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createAnOrderTest() throws Exception {

        String phoneNumber = "+380111";

        Mockito.when(orderService.createAnOrder(2L, phoneNumber))
                .thenReturn(new ResponseEntity(HttpStatus.OK));

        this.mockMvc.perform(post("/shop/{id}", 2)
                        .contentType(MediaType.TEXT_PLAIN)
                        .content(phoneNumber))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getAllCustomerOrdersTest() throws Exception {

        var customer = Customer.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("+380111")
                .build();

        var product = Product.builder()
                .id(1L)
                .productName("name")
                .productDescription("desc")
                .productPrice(200)
                .build();

        var order = Order.builder()
                .id(1L)
                .customer(customer)
                .product(product)
                .build();

        List<Order> orderList = List.of(order);

        Mockito.when(orderService.getAllCustomerOrders(1L)).thenReturn(orderList);

        this.mockMvc.perform(get("/profile/{id}/cart", "1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(jsonPath("$.size()", Matchers.is(1)));

    }

    @Test
    public void deleteAnOrderTest() throws Exception {

        var customer = Customer.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("+380111")
                .build();

        var product = Product.builder()
                .id(1L)
                .productName("name")
                .productDescription("desc")
                .productPrice(200)
                .build();

        Mockito.when(orderService.deleteAnOrder(customer.getId(), product.getId()))
                .thenReturn(new ResponseEntity(HttpStatus.OK));

        this.mockMvc.perform(delete("/profile/{id}/cart", "1")
                .param("productId", "1"))
                .andExpect(status().is2xxSuccessful());

    }
}