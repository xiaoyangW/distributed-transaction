package com.xiaoyang.warehousingservice.service.impl;

import com.xiaoyang.warehousingservice.mapper.WarehousingMapper;
import com.xiaoyang.warehousingservice.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousingServiceImpl implements WarehousingService {

    @Autowired
    private WarehousingMapper warehousingMapper;


    @Override
    public void decrease(Long productId, Integer count) {
        warehousingMapper.decrease(productId, count);
    }
}
