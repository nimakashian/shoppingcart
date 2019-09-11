package com.mycompany.shoppingcart.repoaitory;

import com.mycompany.shoppingcart.domain.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders,String> {
    Optional<Orders> findByOrderNumber(String orderNumber);
}
