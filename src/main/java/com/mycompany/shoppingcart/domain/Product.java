package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import java.sql.Blob;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Product extends ShopEntity {


    private Byte[] image;
    private String pcode;
    private String name;
    private Float price;
    private LocalDateTime expire;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private Discount discount;

    public Product(String pcode) {
        this.pcode=pcode;
    }
    public Product() {
        this.pcode=pcode;
    }

}
