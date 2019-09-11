package com.mycompany.shoppingcart.repoaitory;

import com.mycompany.shoppingcart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,String> {
    Optional<Product> findByPcode(String pcode);
}
