package com.mxzx.sanmao.service;

import com.mxzx.sanmao.Application;
import com.mxzx.sanmao.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void save() throws Exception {
        Customer customer = new Customer()
                .setNo("007")
                .setCompany("巨象2")
                .setName("小胡3")
                .setAddress("西湖4")
                .setPhone("911");
        System.out.println(customerService.save(customer));
    }

}