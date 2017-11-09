package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ProductController extends CommonController<Product, Long> {

    private static final String MODULE = "products";

    @PostMapping(MODULE)
    @Override
    protected Result<Boolean> create(Product product) {
        logger.debug("create {}", product);
        return Result.success(true);
    }

    @GetMapping(MODULE)
    @Override
    protected Result<List<Product>> retrieve(Product product) {
        String name = Optional.ofNullable(product.getName()).orElse("");
        logger.debug("retrieve by {}", name);
        return Result.success(productService.list(name));
    }

    @PutMapping(MODULE)
    @Override
    protected Result<Boolean> update(Product product) {
        return Result.error();
    }

    @DeleteMapping(MODULE)
    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
