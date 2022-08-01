package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.CurrentProductDto;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("Add new pizza to the shop")
    @PostMapping("/shop/new")
    public ResponseEntity<FillProductDto> addNewPizza(@RequestBody Product product) {
        return productService.addNewPizza(product);
    }

    @ApiOperation("Get all pizza's list")
    @GetMapping("/shop")
    public List<MenuProductDto> allPizzas() {
        return productService.allPizzas();
    }

    @ApiOperation("Get current pizza by id")
    @GetMapping("/shop/{id}")
    public CurrentProductDto getPizzaById(@PathVariable("id") Long id) {
        return productService.getPizzaById(id);
    }

    @ApiOperation("Delete current pizza by id")
    @DeleteMapping("/shop/{id}")
    public ResponseEntity<Product> deletePizzaById(@PathVariable("id") Long id) {
        return productService.deletePizzaById(id);
    }

}
