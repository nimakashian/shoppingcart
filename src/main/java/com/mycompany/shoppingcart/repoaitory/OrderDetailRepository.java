package com.mycompany.shoppingcart.repoaitory;

import com.mycompany.shoppingcart.domain.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail,String> {
}
