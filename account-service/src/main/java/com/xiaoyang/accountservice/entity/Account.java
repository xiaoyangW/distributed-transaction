package com.xiaoyang.accountservice.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author WXY
 */
@Data
public class Account {
    private Long id;

    private Long userId;

    /**总额度*/
    private BigDecimal total;

    /**已用额度*/
    private BigDecimal used;
    /**可用额度*/
    private BigDecimal residue;
}
