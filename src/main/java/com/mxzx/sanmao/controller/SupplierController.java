package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class SupplierController extends CommonController<Supplier, Long> {

    private static final String MODULE = "suppliers";

    @PostMapping(MODULE)
    @Override
    protected Result<Boolean> create(Supplier supplier) {
        logger.debug("create {}", supplier);
        return Result.success(true);
    }

    @GetMapping(MODULE)
    @Override
    protected Result<List<Supplier>> retrieve(Supplier supplier) {
        String name = Optional.ofNullable(supplier.getName()).orElse("");
        logger.debug("retrieve by {}", name);
        return Result.success(supplierService.list(name));
    }

    @PutMapping(MODULE)
    @Override
    protected Result<Boolean> update(Supplier supplier) {
        return Result.error();
    }

    @DeleteMapping(MODULE)
    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
