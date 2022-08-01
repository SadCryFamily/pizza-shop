package com.app.pizzashop.service;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.CurrentProductDto;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<FillProductDto> addNewPizza(Product product);

    List<MenuProductDto> allPizzas();

    CurrentProductDto getPizzaById(Long id);

}
