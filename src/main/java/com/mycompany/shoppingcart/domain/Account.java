package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Account extends ShopEntity {

    @Column(unique = true)
    private String username;
    private Boolean active;
    private String password;
    private String userrole;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true,referencedColumnName = "ID")
    private Address address;

}
