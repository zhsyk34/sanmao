package com.mxzx.sanmao.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mxzx.sanmao.Application;
import com.mxzx.sanmao.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Slf4j
public class RepositoryTest {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void saveSupplier() throws Exception {
        List<Supplier> list = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Supplier supplier = new Supplier()
                    .setName("老板" + i)
                    .setAddress("西湖" + i)
                    .setPhone("133009" + i);
            list.add(supplier);
        }
        supplierRepository.save(list);
    }

    @Test
    public void saveCustomer() throws Exception {
        Customer customer = new Customer()
                .setNo("001")
                .setCompany("巨象")
                .setName("小胡")
                .setAddress("西湖")
                .setPhone("110");
        System.out.println(customerRepository.save(customer));
    }

    @Test
    public void saveProduct() throws Exception {
        List<Product> list = new ArrayList<>();
        for (int i = 10; i < 15; i++) {
            Product product = new Product()
                    .setNo("00" + i)
                    .setName("p" + i)
                    .setUnit("平方米")
                    .setPrice(100 + i);
            list.add(product);
        }
        productRepository.save(list);
    }

    @Test
    public void saveOrders() throws Exception {
        Orders orders = new Orders()
                .setSupplier(new Supplier().setId(1L))
                .setCustomer(new Customer().setId(2L))
                .setTotal(100)
                .setReduce(0)
                .setPaid(10)
                .setRecorder("Miss");
        ordersRepository.save(orders);
    }

    @Test
    public void saveDetails() throws Exception {
        Detail detail = new Detail()
                .setOrders(new Orders().setId(5L))
                .setProduct(new Product().setId(4L))
                .setName("2-2")
                .setContent("小单2")
                .setWidth(25)
                .setHeight(120)
                .setMoney(8)
                .setRemarks("...");
        detailRepository.save(detail);
    }

    @Test
    public void findRel() throws Exception {
        ordersRepository.findAll().forEach(orders -> {
            System.err.println("id" + orders.getId());
            orders.getDetails().forEach(System.err::println);
        });
    }

    @Test
    public void findDto() throws Exception {
        ordersRepository.listDto().forEach(System.out::println);
    }

    @Test
    public void findByNameLike() throws Exception {
        customerRepository.findByNameContains("Hu").forEach(System.out::println);
    }

    @Test
    public void createPostData() throws Exception {
        Orders orders = ordersRepository.findOne(1L);
        System.out.println(orders);
        System.err.println(mapper.writeValueAsString(orders));
    }
}