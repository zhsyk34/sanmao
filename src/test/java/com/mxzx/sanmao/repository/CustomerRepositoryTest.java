package com.mxzx.sanmao.repository;

import com.mxzx.sanmao.*;
import com.mxzx.sanmao.entity.*;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void save() throws Exception {

        Customer customer = new Customer()
                .no("001")
                .company("JuXiang")
                .name("Hu")
                .address("XiHu")
                .phone("110");
        Customer customer2 = new Customer()
                .no("001")
                .company("巨象")
                .name("小胡")
                .address("西湖")
                .phone("110");
        System.out.println(customerRepository.save(customer2));
    }
}