package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class CustomerController extends CommonController<Customer, Long> {

    private static final String MODULE = "customers";

    @PostMapping(MODULE)
    @Override
    protected Result<Boolean> create(Customer customer) {
        logger.debug("create {}", customer);
        return Result.success(true);
    }

    @GetMapping(MODULE)
    @Override
    protected Result<List<Customer>> retrieve(Customer customer) {
        String name = Optional.ofNullable(customer.getName()).orElse("");
        logger.debug("retrieve by {}", name);
        return Result.success(customerService.list(name));
    }

    @PutMapping(MODULE)
    @Override
    protected Result<Boolean> update(Customer customer) {
        return Result.error();
    }

    @DeleteMapping(MODULE)
    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
