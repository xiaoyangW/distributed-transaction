package com.xiaoyang.orderservice.entity;

import lombok.Data;

import java.math.BigDecimal;


/**
 * @author WXY
 */
@Data
public class Order {

    private Long id;
    private String orderNo;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;

}
