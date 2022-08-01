package com.app.pizzashop.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_price", nullable = false)
    private String productPrice;

}
