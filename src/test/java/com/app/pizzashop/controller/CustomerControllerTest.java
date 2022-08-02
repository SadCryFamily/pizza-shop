package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.mapper.CustomerMapper;
import com.app.pizzashop.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @MockBean
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addNewCustomerTest() throws Exception {

        var customer = Customer.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("+380111")
                .build();

        var customerDto = customerMapper.toDto(customer);

        Mockito.when(customerService.addNewCustomer(customer)).thenReturn(customerDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(customer)))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getCustomerProfileInfo() throws Exception {

        var customer = Customer.builder()
                .id(1L)
                .firstName("test")
                .lastName("test")
                .phone("+380111")
                .build();

        var mappedCustomer = customerMapper.toFullDto(customer);

        Mockito.when(customerService.getCustomerProfileInfo(customer.getId())).thenReturn(mappedCustomer);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile").param("id","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id", Matchers.is(1)))
                .andExpect(jsonPath("$.firstName", Matchers.is("test")))
                .andExpect(jsonPath("$.lastName", Matchers.is("test")))
                .andExpect(jsonPath("$.phone", Matchers.is("+380111")));

    }
}