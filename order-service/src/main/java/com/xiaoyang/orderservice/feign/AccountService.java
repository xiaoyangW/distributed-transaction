package com.xiaoyang.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-service")
public interface AccountService {

    @RequestMapping(method=RequestMethod.POST,value = "/account/consume")
    String consume(@RequestParam("userId") Long userId, @RequestParam("quota") BigDecimal quota);

}
