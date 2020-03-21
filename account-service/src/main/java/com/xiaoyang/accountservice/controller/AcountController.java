package com.xiaoyang.accountservice.controller;


import com.xiaoyang.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("account")
public class AcountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("consume")
    public String consume(Long userId, BigDecimal quota){
        accountService.consume(userId, quota);
        return "success";
    }


}
