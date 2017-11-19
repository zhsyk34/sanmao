package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Supplier;
import com.mxzx.sanmao.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Page<Supplier> list(String name, Pageable pageable) {
        return supplierRepository.findByNameContains(name, pageable);
    }
}
