package com.app.pizzashop.repository;

import com.app.pizzashop.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o.order_id, c.customer_id, p.product_id, p.product_name, p.product_price FROM orders AS o INNER JOIN customer AS c ON o.customer_id = c.customer_id LEFT JOIN product AS p ON p.product_id = o.product_id WHERE c.customer_id IN (:id) ORDER BY o.order_id ASC;\n", nativeQuery = true)
    List<Order> getCustomerCart(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM orders WHERE customer_id IN (:id) AND product_id IN (:productId);", nativeQuery = true)
    void deleteOrderByCustomerIdAndProductId(@Param("id") Long id, @Param("productId") Long productId);

}
