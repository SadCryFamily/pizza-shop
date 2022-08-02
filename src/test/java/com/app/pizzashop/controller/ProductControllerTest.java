package com.app.pizzashop.controller;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.MenuProductDto;
import com.app.pizzashop.mapper.ProductMapper;
import com.app.pizzashop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addNewPizzaTest() throws Exception {

        var product = Product.builder()
                .id(1L)
                .productName("name")
                .productDescription("desc")
                .productPrice(200)
                .build();

        Mockito.when(productService.addNewPizza(product))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));

        this.mockMvc.perform(post("/shop/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().is2xxSuccessful());

    }


    @Test
    public void allPizzasTest() throws Exception {

        var product = Product.builder()
                .id(1L)
                .productName("name")
                .productDescription("desc")
                .productPrice(200)
                .build();

        var mappedProduct = productMapper.toMenuDto(product);

        List<MenuProductDto> productDtoList = List.of(mappedProduct);

        Mockito.when(productService.allPizzas()).thenReturn(productDtoList);

        this.mockMvc.perform(get("/shop"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.[0].productName", is("name")))
                .andExpect(jsonPath("$.[0].productPrice", is("200")));

    }

    @Test
    public void getPizzaByIdTest() throws Exception {

        var product = Product.builder()
                .id(1L)
                .productName("name")
                .productDescription("desc")
                .productPrice(200)
                .build();

        var mappedProduct = productMapper.toCurrentDto(product);

        Mockito.when(productService.getPizzaById(1L)).thenReturn(mappedProduct);

        this.mockMvc.perform(get("/shop/{id}", 1))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.productName", is("name")))
                .andExpect(jsonPath("$.productDescription", is("desc")))
                .andExpect(jsonPath("$.productPrice", is("200")));

    }

    @Test
    public void deletePizzaByIdTest() throws Exception {

        Mockito.when(productService.deletePizzaById(1L))
                .thenReturn(new ResponseEntity<>(HttpStatus.ACCEPTED));

        this.mockMvc.perform(delete("/shop/{id}", 1))
                .andExpect(status().is2xxSuccessful());

    }
}