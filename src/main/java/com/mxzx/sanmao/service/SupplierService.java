package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Supplier;
import com.mxzx.sanmao.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public Long save(Supplier supplier) {
        return supplierRepository.save(supplier).getId();
    }

    public List<Supplier> list(String name) {
        return supplierRepository.findByNameContains(name);
    }
}
