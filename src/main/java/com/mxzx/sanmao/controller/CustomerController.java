package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("customers")
@Slf4j
public class CustomerController extends CommonController<Customer, Long> {

    @Override
    protected Result<Boolean> create(Customer customer) {
        logger.debug("create {}", customer);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Customer>> retrieve(Customer customer, @PageableDefault(sort = "id", direction = Direction.DESC) Pageable pageable) {
        String name = Optional.ofNullable(customer.getName()).orElse("");
        logger.debug("retrieve by {} and page: {}", name, pageable);
        Page<Customer> page = customerService.list(name, pageable);
        return Result.success(page);
    }

    @Override
    protected Result<Boolean> update(Customer customer) {
        return Result.error();
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
