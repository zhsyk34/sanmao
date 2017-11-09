package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Product;
import com.mxzx.sanmao.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    public Long save(Product product) {
        return productRepository.save(product).getId();
    }

    public List<Product> list(String name) {
        return productRepository.findByNameContains(name);
    }
}
