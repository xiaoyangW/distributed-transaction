package com.xiaoyang.orderservice.mapper;


import com.xiaoyang.orderservice.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {

    @Insert("insert into `order`(user_id,product_id,count,money,`status`)values(#{userId},#{productId},#{count},#{money},#{status})")
    void addOrder(Order order);


}
