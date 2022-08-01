package com.app.pizzashop.repository;

import com.app.pizzashop.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product getProductById(Long id);

    @Modifying
    @Query(value = "DELETE FROM product WHERE product_id in (:id);", nativeQuery = true)
    void deleteProductById(@Param("id") Long id);

}
