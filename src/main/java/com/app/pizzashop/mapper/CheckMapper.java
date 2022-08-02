package com.app.pizzashop.mapper;

import com.app.pizzashop.dao.Check;
import com.app.pizzashop.dto.SimpleCustomerCheckDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CheckMapper {

    CheckMapper INSTANCE = Mappers.getMapper(CheckMapper.class);

    SimpleCustomerCheckDto toSimpleDto(Check check);

}
