package com.app.pizzashop.service;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.CurrentProductDto;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.mapper.ProductMapper;
import com.app.pizzashop.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<FillProductDto> addNewPizza(Product product) {

        log.info("Add new pizza with NAME: {}", product.getProductName());

        Optional.of(productRepository.save(product))
                .map(dao -> productMapper.toFillDto(dao)).orElseThrow();

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public List<MenuProductDto> allPizzas() {

        log.info("Get all pizzas");

        return productRepository.findAll().stream()
                .map(product -> productMapper.toMenuDto(product))
                .collect(Collectors.toList());

    }

    @Override
    public CurrentProductDto getPizzaById(Long id) {

        log.info("Get pizza by ID: {}", id);

        var r = productRepository.getProductById(id);

        return productMapper.toCurrentDto(r);

    }

    @Override
    @Transactional
    public ResponseEntity<Product> deletePizzaById(Long id) {

        log.info("Delete pizza by ID: {}", id);

        productRepository.deleteProductById(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }
}
