package com.xiaoyang.orderservice.message;


import com.alibaba.fastjson.JSON;
import com.xiaoyang.orderservice.controller.OrderController;
import com.xiaoyang.orderservice.entity.Order;
import com.xiaoyang.orderservice.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author WXY
 */
@Slf4j
@Component
@RocketMQTransactionListener(txProducerGroup = OrderController.CREATE_ORDER_PRODUCER_GROUP)
public class OrderTxMsgListener implements RocketMQLocalTransactionListener {

    @Autowired
    private  OrderMapper orderMapper;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        try {
            String jsonOrder = new String((byte[])message.getPayload());
            log.info("消息发送成功：{}",new String((byte[])message.getPayload()));
            //幂等
            Order order = JSON.parseObject(jsonOrder, Order.class);
            if (orderMapper.getOrderCount(order.getOrderNo())>0){
                return RocketMQLocalTransactionState.COMMIT;
            }
            orderMapper.addOrder(order);
            return RocketMQLocalTransactionState.COMMIT;
        }catch (Exception e){
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String jsonOrder = new String((byte[])message.getPayload());
        log.info("消息回查：{}",new String((byte[])message.getPayload()));
        //幂等
        Order order = JSON.parseObject(jsonOrder, Order.class);
        if (orderMapper.getOrderCount(order.getOrderNo())>0){
            return RocketMQLocalTransactionState.COMMIT;
        }
        return RocketMQLocalTransactionState.UNKNOWN;
    }
}
