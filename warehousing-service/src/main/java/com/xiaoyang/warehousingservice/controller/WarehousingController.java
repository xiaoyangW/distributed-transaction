package com.xiaoyang.warehousingservice.controller;

import com.xiaoyang.warehousingservice.service.WarehousingService;
import io.seata.core.context.RootContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("storage")
public class WarehousingController {

    @Autowired
    private WarehousingService warehousingService;

    @PostMapping("decrease")
    public String decrease(Long productId, Integer count,@RequestHeader Map<String, String> headers) {
        //使用webflux时手动绑定
        if (StringUtils.isNotBlank(headers.get(RootContext.KEY_XID))){
            RootContext.bind(headers.get(RootContext.KEY_XID));
        }
        warehousingService.decrease(productId, count);
        return "";
    }

}
