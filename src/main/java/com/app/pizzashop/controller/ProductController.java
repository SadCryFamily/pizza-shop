package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.CurrentProductDto;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/shop/new")
    public ResponseEntity<FillProductDto> addNewPizza(@RequestBody Product product) {
        return productService.addNewPizza(product);
    }

    @GetMapping("/shop")
    public List<MenuProductDto> allPizzas() {
        return productService.allPizzas();
    }

    @GetMapping("/shop/{id}")
    public CurrentProductDto getPizzaById(@PathVariable("id") Long id) {
        return productService.getPizzaById(id);
    }

}
