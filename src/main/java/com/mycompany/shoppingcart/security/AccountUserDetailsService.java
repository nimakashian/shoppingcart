package com.mycompany.shoppingcart.security;

import com.mycompany.shoppingcart.domain.Account;
import com.mycompany.shoppingcart.exception.ShopSecurityException;
import com.mycompany.shoppingcart.repoaitory.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

public class AccountUserDetailsService implements UserDetailsService {

    private AccountRepository accountRepository;

    public AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Optional<Account> optionalAccount=accountRepository.findByUsername(username);
            if(optionalAccount.isPresent()){

                Account account=optionalAccount.get();

//                PasswordEncoder passwordEncoder= PasswordEncoderFactories
//                        .createDelegatingPasswordEncoder();
                PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

                String password;
                        password=passwordEncoder.encode(account.getPassword());


                return User
                        .withUsername(account.getUsername())
                        .accountLocked(!account.getActive())
                        .password(password)
                        .roles(account.getUserrole())
                        .build();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        throw new UsernameNotFoundException(username);
    }


}
