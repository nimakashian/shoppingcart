package com.mycompany.shoppingcart.repoaitory;


import com.mycompany.shoppingcart.domain.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {
}
