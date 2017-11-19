package com.mxzx.sanmao.service;

import com.mxzx.sanmao.entity.Customer;
import com.mxzx.sanmao.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//只有一个构造器可以不用显示注入?
@Service
@RequiredArgsConstructor/*(onConstructor = @__(@Autowired))*/
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Page<Customer> list(String name, Pageable pageable) {
        return customerRepository.findByNameContains(name, pageable);
    }
}
