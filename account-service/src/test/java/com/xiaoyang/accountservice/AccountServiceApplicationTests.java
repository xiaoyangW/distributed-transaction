
package com.xiaoyang.accountservice;

import com.xiaoyang.accountservice.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceApplicationTests {

    @Autowired
    AccountMapper accountMapper;

    @Test
    public void contextLoads() {

        System.out.println(accountMapper.selectAccountById(1L));
    }

}

