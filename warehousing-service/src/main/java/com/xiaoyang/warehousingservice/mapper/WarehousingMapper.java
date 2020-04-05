package com.xiaoyang.warehousingservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author WXY
 */
@Repository
@Mapper
public interface WarehousingMapper {
    /**
     * 扣减库存
     * @param productId 商品ID
     * @param count 数量
     */
    @Update("update storage set used=used+#{count},residue=residue-#{count} where product_id=#{productId}")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
