package com.xiaoyang.warehousingservice.entity;

import lombok.Data;

/**
 * @author WXY
 */
@Data
public class Storage {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
