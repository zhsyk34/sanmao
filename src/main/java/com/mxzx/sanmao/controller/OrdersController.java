package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@Slf4j
public class OrdersController extends CommonController<Orders, Long> {

    @Override
    protected Result<Boolean> create(@RequestBody Orders orders) {
        logger.debug("create {}", orders);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Orders>> retrieve(Orders orders, Pageable pageable) {
        return null;
    }

    @Override
    protected Result<Boolean> update(Orders orders) {
        return Result.error();
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
