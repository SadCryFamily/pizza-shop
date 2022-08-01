package com.app.pizzashop.service;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.FillProductDto;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.mapper.ProductMapper;
import com.app.pizzashop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ResponseEntity<FillProductDto> addNewPizza(Product product) {

        Optional.of(productRepository.save(product))
                .map(dao -> productMapper.toFillDto(dao)).orElseThrow();

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public List<MenuProductDto> allPizzas() {

        return productRepository.findAll().stream()
                .map(product -> productMapper.toMenuDto(product))
                .collect(Collectors.toList());

    }
}
