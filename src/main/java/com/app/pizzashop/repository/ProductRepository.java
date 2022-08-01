package com.app.pizzashop.repository;

import com.app.pizzashop.dao.Product;
import com.app.pizzashop.dto.FillProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

}
