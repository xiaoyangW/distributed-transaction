package com.xiaoyang.warehousingservice;

import com.xiaoyang.warehousingservice.config.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class WarehousingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarehousingServiceApplication.class, args);
    }

}
