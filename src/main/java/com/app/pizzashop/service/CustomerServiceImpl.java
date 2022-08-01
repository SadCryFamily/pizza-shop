package com.app.pizzashop.service;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import com.app.pizzashop.mapper.CustomerMapper;
import com.app.pizzashop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer addNewCustomer(Customer customer) {
        return Optional.of(customerRepository.saveAndFlush(customer)).orElseThrow();
    }

    @Override
    public FullCustomerInfoDto getCustomerProfileInfo(Long id) {
        return customerRepository.findById(id)
                .map(customer -> customerMapper.toFullDto(customer)).orElseThrow();
    }
}
