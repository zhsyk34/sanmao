package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("customers")
@Slf4j
public class CustomerController extends CommonController<Customer, Long> {

    @Override
    protected Result<Boolean> create(@RequestBody Customer customer) {
        logger.debug("create {}", customer);
        customerService.save(customer);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Customer>> retrieve(Customer customer, Pageable pageable) {
        String name = Optional.ofNullable(customer.getName()).orElse("");
        logger.debug("retrieve by name: {} and page: {}", name, pageable);
        Page<Customer> page = customerService.list(name, pageable);
        return Result.success(page);
    }

    @Override
    protected Result<Boolean> update(@RequestBody Customer customer) {
        logger.debug("update {}", customer);
        customerService.save(customer);
        return Result.success();
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.success();
    }
}
