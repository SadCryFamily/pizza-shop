package com.app.pizzashop.mapper;

import com.app.pizzashop.dao.Customer;
import com.app.pizzashop.dto.CustomerDto;
import com.app.pizzashop.dto.FullCustomerInfoDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDto toDto(Customer customer);

    @Mapping(source = "id", target = "id")
    FullCustomerInfoDto toFullDto(Customer customer);

    @Mapping(source = "id", target = "id")
    Customer toEntity(FullCustomerInfoDto fullCustomerInfoDto);

}
