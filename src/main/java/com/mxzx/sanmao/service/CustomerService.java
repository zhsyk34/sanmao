package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Customer;
import com.mxzx.sanmao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Long save(Customer customer) {
        return customerRepository.save(customer).getId();
    }

    public List<Customer> list(String name) {
        return customerRepository.findByNameContains(name);
    }
}
