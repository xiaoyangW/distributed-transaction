package com.xiaoyang.warehousingservice.service.impl;

import com.xiaoyang.warehousingservice.mapper.WarehousingMapper;
import com.xiaoyang.warehousingservice.service.WarehousingService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("全局事务ID:{}", RootContext.getXID());
        warehousingMapper.decrease(productId, count);
    }
}
