package com.mycompany.shoppingcart.dto;


import com.mycompany.shoppingcart.domain.Discount;
import com.mycompany.shoppingcart.domain.OrderDetail;
import com.mycompany.shoppingcart.domain.Orders;
import com.mycompany.shoppingcart.domain.Product;
import com.mycompany.shoppingcart.repoaitory.DiscountRepository;
import com.mycompany.shoppingcart.repoaitory.OrdersRepository;
import com.mycompany.shoppingcart.repoaitory.ProductRepository;
import lombok.Data;

@Data
public class OrderDetailDto {
    private Float amount;
    private Float price;
    private Integer quantity;
    private String orderNumber;
    private String pcode;
    private String discountId;

    private OrdersRepository ordersRepository;
    private ProductRepository productRepository;
    private DiscountRepository discountRepository;


    public OrderDetail createOrderDetail() {
        OrderDetail orderDetail=new OrderDetail();

        orderDetail.setQuantity(getQuantity());
        orderDetail.setPrice(getPrice());
        orderDetail.setAmount(getAmount());
        Orders order =ordersRepository.findByOrderNumber(orderNumber).get();
        orderDetail.setOrders(order);
        Product product=productRepository.findByPcode(pcode).get();
        orderDetail.setProduct(product);
        Discount discount=discountRepository.findById(discountId).get();
        orderDetail.setDiscount(discount);

        return orderDetail;
    }
}
