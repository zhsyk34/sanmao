package com.mxzx.sanmao.repository;

import com.mxzx.sanmao.Application;
import com.mxzx.sanmao.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerRepositoryTest {
    @Test
    public void findByNameLike() throws Exception {
        customerRepository.findByNameLike("%Hu%").forEach(System.out::println);
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findByName() throws Exception {
        Customer customer = customerRepository.findByName("Hu10");
        System.out.println(customer);
    }

    @Test
    public void save() throws Exception {
        Customer customer = new Customer()
                .no("001")
                .company("巨象")
                .name("小胡")
                .address("西湖")
                .phone("110");
        System.out.println(customerRepository.save(customer));
    }

    @Test
    public void save2() throws Exception {
        List<Customer> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            Customer customer = new Customer()
                    .no("00" + i)
                    .company("company" + i)
                    .name("Hu" + i)
                    .address("XiHu" + i)
                    .phone("110" + i);
            list.add(customer);
        }
        customerRepository.save(list);
    }
}