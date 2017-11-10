package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.service.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

abstract class CommonController<T, K> {
    @Setter(onMethod = @__({@Autowired}))
    protected SupplierService supplierService;
    @Setter(onMethod = @__({@Autowired}))
    protected CustomerService customerService;
    @Setter(onMethod = @__({@Autowired}))
    protected ProductService productService;
    @Setter(onMethod = @__({@Autowired}))
    protected OrdersService ordersService;

    @PostMapping
    protected abstract Result<Boolean> create(T t);

    @GetMapping
    protected abstract Result<Page<T>> retrieve(T t, Pageable pageable);

    @PutMapping
    protected abstract Result<Boolean> update(T t);

    @DeleteMapping
    protected abstract Result<Boolean> delete(K k);
}
