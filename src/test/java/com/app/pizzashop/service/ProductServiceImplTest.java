package com.app.pizzashop.service;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.mapper.ProductMapper;
import com.app.pizzashop.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceImplTest {


    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductService productService;

    @Test
    public void addNewPizzaTest() {

        var product = Product.builder()
                .id(10L)
                .productName("test")
                .productDescription("test")
                .productPrice(200)
                .build();

        Mockito.when(productRepository.save(product)).thenReturn(product);

        var mappedProduct = productMapper.toFillDto(product);

        var result = productService.addNewPizza(product);

        assertEquals(result.getStatusCodeValue(),
                new ResponseEntity(HttpStatus.OK).getStatusCodeValue());

    }

    @Test
    public void allPizzasTest() {

        var product = Product.builder()
                .id(10L)
                .productName("test")
                .productDescription("test")
                .productPrice(200)
                .build();

        List<Product> productList = List.of(product);

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<MenuProductDto> mappedProductList = productList.stream()
                .map(dao -> productMapper.toMenuDto(dao))
                .collect(Collectors.toList());

        var result = productService.allPizzas();

        assertEquals(result.get(0).getProductName(),
                mappedProductList.get(0).getProductName());

        assertEquals(result.get(0).getProductPrice(),
                mappedProductList.get(0).getProductPrice());

    }

    @Test
    public void getPizzaByIdTest() {

        var product = Product.builder()
                .id(10L)
                .productName("test")
                .productDescription("test")
                .productPrice(200)
                .build();

        Mockito.when(productRepository.getProductById(product.getId())).thenReturn(product);

        var mappedProduct = productMapper.toCurrentDto(product);

        var result = productService.getPizzaById(product.getId());

        assertEquals(result.getProductName(), mappedProduct.getProductName());
        assertEquals(result.getProductDescription(), mappedProduct.getProductDescription());
        assertEquals(result.getProductPrice(), mappedProduct.getProductPrice());

    }

}