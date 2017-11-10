package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController extends CommonController<Product, Long> {

    @Override
    protected Result<Boolean> create(Product product) {
        logger.debug("create {}", product);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Product>> retrieve(Product product, Pageable pageable) {
        return null;
    }

    @Override
    protected Result<Boolean> update(Product product) {
        return Result.error();
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
