package com.mycompany.shoppingcart.controller;


import com.mycompany.shoppingcart.domain.Account;
import com.mycompany.shoppingcart.domain.Orders;
import com.mycompany.shoppingcart.repoaitory.AccountRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showcase")
public class AccountController {

    private AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account")
    public ResponseEntity<Iterable<Account>> getAccounts() {
        return ResponseEntity.ok(accountRepository.findAll());
    }

}
