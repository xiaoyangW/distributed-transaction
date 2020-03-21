package com.xiaoyang.accountservice.service;

import java.math.BigDecimal;

/**
 * @author WXY
 */
public interface AccountService {

    /**
     * 消费
     * @param userId 消费用户id
     * @param quota 消费金额
     */
    void consume(Long userId, BigDecimal quota);

}
