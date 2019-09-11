package com.mycompany.shoppingcart.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Discount extends ShopEntity {

    private Float amount;
    private Boolean active;
    private LocalDateTime start;
    private LocalDateTime end;
}
