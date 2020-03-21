package com.xiaoyang.accountservice.mapper;

import com.xiaoyang.accountservice.entity.Account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;
import java.math.BigDecimal;

/**
 * @author WXY
 */
@Mapper
@Repository
public interface AccountMapper {

    @Results(id ="AccountResultMap",value = {
            @Result(column = "id",property = "id"),
            @Result(column = "user_id",property = "userId"),
            @Result(column = "total",property = "total"),
            @Result(column = "used",property = "used"),
            @Result(column = "residue",property = "residue")
    })
    @Select("select * from account where user_id = #{userId}")
    Account selectAccountById(Long userId);

    @Update("update account set residue=residue-#{quota},used=used+#{quota} where user_id=#{userId}")
    Integer consume(Long userId, BigDecimal quota);

}
