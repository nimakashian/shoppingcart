package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Orders extends ShopEntity {

    private Float total;
    private LocalDateTime orderDate;
    @Column(unique = true)
    private String orderNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "username")
    private Account account;
}
