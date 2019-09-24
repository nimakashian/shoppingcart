package com.mycompany.shoppingcart.config;

import com.mycompany.shoppingcart.repoaitory.AccountRepository;
import com.mycompany.shoppingcart.security.AccountUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ShopSecurityConfig extends WebSecurityConfigurerAdapter {

    private AccountRepository accountRepository;

    public ShopSecurityConfig(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    protected void configure(
            AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("user1")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN","USER");
        auth.userDetailsService(
                new AccountUserDetailsService(this.accountRepository));

    }

    //TODO custom login
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers(
//                        PathRequest
//                                .toStaticResources()
//                                .atCommonLocations()
//                )
//                .permitAll()
//                .anyRequest()
//                .fullyAuthenticated().and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutRequestMatcher(
//                        new AntPathRequestMatcher("/logout")
//                )
//                .logoutSuccessUrl("/login")
//                .and().httpBasic();
        http
                .authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                .and()
                .httpBasic();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
