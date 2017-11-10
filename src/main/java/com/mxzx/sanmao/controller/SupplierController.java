package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("suppliers")
@Slf4j
public class SupplierController extends CommonController<Supplier, Long> {

    @Override
    protected Result<Boolean> create(Supplier supplier) {
        logger.debug("create {}", supplier);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Supplier>> retrieve(Supplier supplier, Pageable pageable) {
        return null;
    }

    @Override
    protected Result<Boolean> update(Supplier supplier) {
        return Result.error();
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
