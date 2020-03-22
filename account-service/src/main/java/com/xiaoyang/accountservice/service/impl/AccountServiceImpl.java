package com.xiaoyang.accountservice.service.impl;

import com.xiaoyang.accountservice.mapper.AccountMapper;
import com.xiaoyang.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Override
    public void consume(Long userId, BigDecimal quota) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("account consume start :{}",userId);
        accountMapper.consume(userId, quota);
        log.info("account consume end");
    }
}
