package com.xiaoyang.orderservice.service.impl;

import com.xiaoyang.orderservice.entity.Order;
import com.xiaoyang.orderservice.feign.AccountService;
import com.xiaoyang.orderservice.mapper.OrderMapper;
import com.xiaoyang.orderservice.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private AccountService accountService;
    @Override
    @GlobalTransactional(name = "account-service-create-order",rollbackFor = Exception.class)
    public void createOrder(Order order) {
        log.info("create order start:{}",order);
        orderMapper.addOrder(order);

        log.info("account consume start");
        accountService.consume(order.getUserId(),order.getMoney());

        log.info("order create end");
    }
}
