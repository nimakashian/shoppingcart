package com.mycompany.shoppingcart.repoaitory;


import com.mycompany.shoppingcart.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account,String> {

}
