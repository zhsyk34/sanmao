package com.mxzx.sanmao.repository;

import com.mxzx.sanmao.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

//    List<Supplier> findByName();
}
