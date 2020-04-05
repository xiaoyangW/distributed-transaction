package com.xiaoyang.warehousingservice.controller;

import com.xiaoyang.warehousingservice.service.WarehousingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storage")
public class WarehousingController {

    @Autowired
    private WarehousingService warehousingService;

    @PostMapping("decrease")
    public String decrease(Long productId, Integer count) {
        warehousingService.decrease(productId, count);
        return "";
    }

}
