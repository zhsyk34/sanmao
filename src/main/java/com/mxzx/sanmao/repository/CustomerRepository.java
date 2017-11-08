package com.mxzx.sanmao.repository;

import com.mxzx.sanmao.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByName(String name);

    List<Customer> findByNameLike(String name);
}
