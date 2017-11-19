package com.mxzx.sanmao.controller;

import com.mxzx.sanmao.dto.Result;
import com.mxzx.sanmao.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("products")
@Slf4j
public class ProductController extends CommonController<Product, Long> {

    @Override
    protected Result<Boolean> create(@RequestBody Product product) {
        productService.save(product);
        return Result.success(true);
    }

    @Override
    protected Result<Page<Product>> retrieve(Product product, Pageable pageable) {
        return Result.success(productService.list(Optional.ofNullable(product.getName()).orElse(""), pageable));
    }

    @Override
    protected Result<Boolean> update(@RequestBody Product product) {
        productService.save(product);
        return Result.success(true);
    }

    @Override
    protected Result<Boolean> delete(Long id) {
        return Result.error();
    }
}
