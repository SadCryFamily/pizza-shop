package com.app.pizzashop.repository;

import com.app.pizzashop.dao.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<Check, Long> {

    @Query(value = "SELECT SUM (p.product_price) FROM orders AS o INNER JOIN customer AS c ON o.customer_id = c.customer_id LEFT JOIN product AS p ON p.product_id = o.product_id WHERE c.customer_id IN (:id);", nativeQuery = true)
    Long getCustomerCheckById(@Param("id") Long id);

}
