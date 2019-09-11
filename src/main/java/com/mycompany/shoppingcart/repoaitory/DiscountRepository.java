package com.mycompany.shoppingcart.repoaitory;

import com.mycompany.shoppingcart.domain.Discount;
import org.springframework.data.repository.CrudRepository;

public interface DiscountRepository extends CrudRepository<Discount,String> {
}
