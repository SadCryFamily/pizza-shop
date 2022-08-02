package com.app.pizzashop.service;

import com.app.pizzashop.dto.SimpleCustomerCheckDto;

public interface CheckService {

    SimpleCustomerCheckDto addNewCheckByCustomerId(Long id);

}
