package com.app.pizzashop.service;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.FullCustomerInfoDto;

public interface CustomerService {

    Customer addNewCustomer(Customer customer);

    FullCustomerInfoDto getCustomerProfileInfo(Long id);

}
