package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Orders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrdersController extends CommonController<Orders, Long> {

    private static final String MODULE = "orders";

    @PostMapping(MODULE)
    @Override
    protected Result<Boolean> create(@RequestBody Orders orders) {
        logger.debug("create {}", orders);
        return Result.success(true);
    }

    @GetMapping(MODULE)
    @Override
    protected Result<List<Orders>> retrieve(Orders orders) {
//        String name = Optional.ofNullable(orders.getCustomer().getName()).orElse("");
        logger.debug("retrieve by {}", orders);
        return null;//TODO
//        return Result.success(ordersService.(name));
    }

    @PutMapping(MODULE)
    @Override
    protected Result<Boolean> update(Orders orders) {
        return Result.error();
    }

    @DeleteMapping(MODULE)
    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
