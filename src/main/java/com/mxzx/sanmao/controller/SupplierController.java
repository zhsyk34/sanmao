package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("suppliers")
@Slf4j
public class SupplierController extends CommonController<Supplier, Long> {

    @Override
    protected Result<Boolean> create(@RequestBody Supplier supplier) {
        logger.debug("supplier:{}", supplier);
        supplierService.save(supplier);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Supplier>> retrieve(Supplier supplier, Pageable pageable) {
        Page<Supplier> page = supplierService.list(Optional.ofNullable(supplier.getName()).orElse(""), pageable);
        return Result.success(page);
    }

    @Override
    protected Result<Boolean> update(@RequestBody Supplier supplier) {
        supplierService.save(supplier);
        return Result.success(true);
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
