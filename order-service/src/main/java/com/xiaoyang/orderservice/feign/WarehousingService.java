package com.xiaoyang.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WXY
 */
@FeignClient(value = "warehousing-service")
public interface WarehousingService {

    @RequestMapping(method = RequestMethod.POST,value = "/storage/decrease")
    String decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
