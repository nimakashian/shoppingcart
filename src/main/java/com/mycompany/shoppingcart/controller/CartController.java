package com.mycompany.shoppingcart.controller;


import com.mycompany.shoppingcart.domain.Orders;
import com.mycompany.shoppingcart.domain.Product;
import com.mycompany.shoppingcart.repoaitory.OrderDetailRepository;
import com.mycompany.shoppingcart.repoaitory.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/showcase")
public class CartController {

    private OrdersRepository ordersRepository;
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public CartController(OrdersRepository ordersRepository,
                            OrderDetailRepository orderDetailRepository){
        this.orderDetailRepository=orderDetailRepository;
        this.ordersRepository=ordersRepository;
    }

    @GetMapping("/cart")
    public ResponseEntity<Iterable<Orders>> getOrders() {
        return ResponseEntity.ok(ordersRepository.findAll());


    }

    @GetMapping("/cart/{orderNumber}")
    public ResponseEntity<Orders> getOrder(@PathVariable String orderNumber) {
        Optional<Orders> orders = ordersRepository.findByOrderNumber(orderNumber);
        if (orders.isPresent()) {
            return ResponseEntity.ok(orders.get());
        }
        return ResponseEntity.notFound().build();

    }
}
