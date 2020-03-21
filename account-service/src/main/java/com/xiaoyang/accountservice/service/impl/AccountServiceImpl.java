package com.xiaoyang.accountservice.service.impl;

import com.xiaoyang.accountservice.mapper.AccountMapper;
import com.xiaoyang.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void consume(Long userId, BigDecimal quota) {
        accountMapper.consume(userId, quota);
    }
}
