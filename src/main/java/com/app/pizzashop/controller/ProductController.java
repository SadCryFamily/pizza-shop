package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/new")
    public ResponseEntity<FillProductDto> addNewPizza(@RequestBody Product product) {
        return productService.addNewPizza(product);
    }

    @GetMapping
    public List<MenuProductDto> allPizzas() {
        return productService.allPizzas();
    }

}
