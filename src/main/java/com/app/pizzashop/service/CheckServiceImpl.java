package com.app.pizzashop.service;

import com.app.pizzashop.dao.Check;
import com.app.pizzashop.dto.SimpleCustomerCheckDto;
import com.app.pizzashop.mapper.CheckMapper;
import com.app.pizzashop.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public SimpleCustomerCheckDto addNewCheckByCustomerId(Long id) {

        var customerCheck = checkRepository.getCustomerCheckById(id);

        Check newCheck = Check.builder()
                .totalSum(customerCheck)
                .build();

        checkRepository.save(newCheck);

        return checkMapper.toSimpleDto(newCheck);
    }
}
