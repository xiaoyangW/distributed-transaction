package com.xiaoyang.orderservice.message;


import com.xiaoyang.orderservice.controller.OrderController;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author WXY
 */
@Slf4j
@Component
@RocketMQTransactionListener(txProducerGroup = OrderController.CREATE_ORDER_PRODUCER_GROUP)
public class OrderTxMsgListener implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("消息发送成功：{}",new String((byte[])message.getPayload()));
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}
