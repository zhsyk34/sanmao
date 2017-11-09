package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.service.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

abstract class CommonController<T, K> {
    @Setter(onMethod = @__({@Autowired}))
    protected SupplierService supplierService;
    @Setter(onMethod = @__({@Autowired}))
    protected CustomerService customerService;
    @Setter(onMethod = @__({@Autowired}))
    protected ProductService productService;
    @Setter(onMethod = @__({@Autowired}))
    protected OrdersService ordersService;

    protected abstract Result<Boolean> create(T t);

    protected abstract Result<List<T>> retrieve(T t);

    protected abstract Result<Boolean> update(T t);

    protected abstract Result<Boolean> delete(K k);
}
