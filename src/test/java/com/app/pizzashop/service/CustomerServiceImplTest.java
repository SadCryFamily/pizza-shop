package com.app.pizzashop.service;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.mapper.CustomerMapper;
import com.app.pizzashop.repository.CustomerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerService customerService;

    @Test
    public void addNewCustomerTest() {

        var customer = Customer.builder()
                .id(1L)
                .firstName("Bill")
                .lastName("Hawkington")
                .phone("+38067676767")
                .regDate(new Date(02, 02, 02))
                .build();

        Mockito.when(customerRepository.saveAndFlush(customer)).thenReturn(customer);

        var mappedCustomer = customerMapper.toBasicDto(customer);

        var result = customerService.addNewCustomer(customer);

        assertEquals(result.getFirstName(), mappedCustomer.getFirstName());
        assertEquals(result.getLastName(), mappedCustomer.getLastName());
        assertEquals(result.getPhone(), mappedCustomer.getPhone());

    }

    @Test
    public void getCustomerProfileInfoTest() {

        var customer = Customer.builder()
                .id(1L)
                .firstName("Bill")
                .lastName("Hawkington")
                .phone("+38067676767")
                .regDate(new Date(02, Calendar.MARCH, 02))
                .build();

        Mockito.when(customerRepository.findById(customer.getId())).thenReturn(Optional.of(customer));

        var mappedCustomer = customerMapper.toFullDto(customer);

        var result = customerService.getCustomerProfileInfo(customer.getId());

        assertEquals(result.getId(), mappedCustomer.getId());
        assertEquals(result.getFirstName(), mappedCustomer.getFirstName());
        assertEquals(result.getLastName(), mappedCustomer.getLastName());
        assertEquals(result.getPhone(), mappedCustomer.getPhone());
        assertEquals(result.getRegDate(), mappedCustomer.getRegDate());

    }


}