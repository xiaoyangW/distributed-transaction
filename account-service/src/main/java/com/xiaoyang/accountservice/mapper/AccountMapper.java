package com.xiaoyang.accountservice.mapper;

import com.xiaoyang.accountservice.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

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



}
