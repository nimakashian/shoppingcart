package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Orders extends ShopEntity {

    private Float total;
    private LocalDateTime orderDate;
    //TODO auto increment
    @Column(unique = true,insertable = false)
    private Integer orderNumber;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "username")
    private Account account;
    private String state;//refer OrderState enum

    @PrePersist
    public void nextOrderNumber(){
        Random r = new Random();
        this.setOrderNumber(r.nextInt());
    }
}
