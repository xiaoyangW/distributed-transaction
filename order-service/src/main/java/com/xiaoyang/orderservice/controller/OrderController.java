package com.xiaoyang.orderservice.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xiaoyang.orderservice.entity.Order;
import com.xiaoyang.orderservice.service.OrderService;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WXY
 */
@RestController
@RequestMapping("order")
public class OrderController {
    public static final String CREATE_ORDER_PRODUCER_GROUP = "orderservice-create-order";
    public static final String CREATE_ORDER_TOPIC = "create-order";
    @Autowired
    RocketMQTemplate rocketMqTemplate;

    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public String create(@RequestBody Order order) {
        orderService.createOrder(order);
        return "success";
    }

    @PostMapping("mqcreate")
    public String mqcreate(@RequestBody Order order) {
        String s = JSONArray.toJSONString(order);
        //发送事务消息,（消息组，topic,消息）
        TransactionSendResult transactionSendResult = rocketMqTemplate.sendMessageInTransaction(
                CREATE_ORDER_PRODUCER_GROUP,
                CREATE_ORDER_TOPIC,
                MessageBuilder.withPayload(s).build(), null);

        return transactionSendResult.getLocalTransactionState().name();
    }
}
