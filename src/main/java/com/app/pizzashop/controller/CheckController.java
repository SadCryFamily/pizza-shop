package com.app.pizzashop.controller;

import com.app.pizzashop.dto.SimpleCustomerCheckDto;
import com.app.pizzashop.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class CheckController {

    @Autowired
    private CheckService checkService;

    @ApiOperation("Get customer check")
    @GetMapping("/profile/{id}/check")
    public SimpleCustomerCheckDto getCustomerCheck(@PathVariable("id") Long id) {
        return checkService.addNewCheckByCustomerId(id);
    }

}
