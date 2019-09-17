package com.mycompany.shoppingcart.repoaitory;


import com.mycompany.shoppingcart.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account,String> {
    Optional<Account> findByUsername(String username);
}
