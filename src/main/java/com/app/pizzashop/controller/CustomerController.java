package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.CustomerDto;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import com.app.pizzashop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/signup")
    public CustomerDto addNewCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

    @GetMapping("/profile")
    public FullCustomerInfoDto getCustomerProfileInfo(@RequestParam Long id) {
        return customerService.getCustomerProfileInfo(id);
    }

}
