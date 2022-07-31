package com.app.pizzashop.mapper;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.CustomerDto;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    FullCustomerInfoDto toFullDto(Customer customer);

    CustomerDto toBasicDto(Customer customer);

    Customer toEntity(FullCustomerInfoDto fullCustomerInfoDto);

}
