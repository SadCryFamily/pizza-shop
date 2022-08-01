package com.app.pizzashop.repository;

import com.app.pizzashop.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o.order_id, o.customer_id, p.product_id, p.product_name, p.product_price FROM orders AS o INNER JOIN product AS p ON p.product_id = o.order_id WHERE o.customer_id IN (:id);", nativeQuery = true)
    List<Order> getCustomerCart(@Param("id") Long id);

}
