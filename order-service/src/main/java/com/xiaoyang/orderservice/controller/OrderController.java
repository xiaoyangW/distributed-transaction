package com.xiaoyang.orderservice.controller;

import com.xiaoyang.orderservice.entity.Order;
import com.xiaoyang.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public String create(@RequestBody Order order){
        orderService.createOrder(order);
        return "success";
    }

}
