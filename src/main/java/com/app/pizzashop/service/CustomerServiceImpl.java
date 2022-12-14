package com.app.pizzashop.service;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.CustomerDto;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import com.app.pizzashop.mapper.CustomerMapper;
import com.app.pizzashop.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public CustomerDto addNewCustomer(Customer customer) {

        log.info("Creating new Customer with PHONE: {}", customer.getPhone());

        return Optional.of(customerRepository.saveAndFlush(customer))
                .map(dao -> customerMapper.toBasicDto(dao)).orElseThrow();
    }

    @Override
    public FullCustomerInfoDto getCustomerProfileInfo(Long id) {

        log.info("Get profile info by ID: {}", id);

        return customerRepository.findById(id)
                .map(customer -> customerMapper.toFullDto(customer)).orElseThrow();
    }
}
