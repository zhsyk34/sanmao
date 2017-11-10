package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Product;
import com.mxzx.sanmao.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    public Long save(Product product) {
        return productRepository.save(product).getId();
    }

    public Page<Product> list(String name, Pageable pageable) {
        return productRepository.findByNameContains(name, pageable);
    }
}
