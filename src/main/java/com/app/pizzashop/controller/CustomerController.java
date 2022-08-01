package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.CustomerDto;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import com.app.pizzashop.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("Register new customer")
    @PostMapping("/signup")
    public CustomerDto addNewCustomer(@RequestBody Customer customer) {
        return customerService.addNewCustomer(customer);
    }

    @ApiOperation("Get customer profile")
    @GetMapping("/profile")
    public FullCustomerInfoDto getCustomerProfileInfo(@RequestParam Long id) {
        return customerService.getCustomerProfileInfo(id);
    }

}
