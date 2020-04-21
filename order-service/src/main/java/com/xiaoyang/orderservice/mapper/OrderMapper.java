package com.xiaoyang.orderservice.mapper;


import com.xiaoyang.orderservice.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author WXY
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 插入订单信息
     * @param order 订单信息
     * @return int
     */
    @Insert("insert into `order`(user_id,product_id,count,money,`status`,order_no)values(#{userId},#{productId},#{count},#{money},#{status},#{orderNo})")
    int addOrder(Order order);

    @Results(id = "orderMap",value = {
            @Result(property = "id",column = "id"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "productId",column = "product_id"),
            @Result(property = "count",column = "count"),
            @Result(property = "status",column = "status"),
            @Result(property = "money",column = "money"),
            @Result(property = "orderNo",column = "order_no")
    })
    @Select("select * from `order` where order_no=#{orderNo} limit 1")
    Order getOrder(String orderNo);

    @Select("select count(order_no) from `order` where order_no=#{orderNo} limit 1")
    int getOrderCount(String orderNo);
}
