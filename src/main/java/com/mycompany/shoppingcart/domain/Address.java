package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Address extends ShopEntity {

    private String addressDetail;
    private String email;
    private String name;
    private String phone;

}
