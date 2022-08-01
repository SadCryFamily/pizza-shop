package com.app.pizzashop.mapper;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    Product toProductEntity(FillProductDto fillProductDto);

    MenuProductDto toMenuDto(FillProductDto fillProductDto);

    MenuProductDto toMenuDto(Product product);

    FillProductDto toFillDto(Product product);

}
