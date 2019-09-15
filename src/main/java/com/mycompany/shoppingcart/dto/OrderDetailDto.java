package com.mycompany.shoppingcart.dto;


import com.mycompany.shoppingcart.domain.OrderDetail;
import lombok.Data;

@Data
public class OrderDetailDto {
    private Float amount;
    private Float price;
    private Integer quantity;
    private String orderNumber;
    private String pcode;
    private String discountId;

    public OrderDetail createOrderDetail() {
        OrderDetail orderDetail=new OrderDetail();
//TODO orderDetail converter
        orderDetail.setQuantity();
        return orderDetail;
    }
}
