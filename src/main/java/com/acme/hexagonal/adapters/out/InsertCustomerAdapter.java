package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.adapters.out.repository.CustomerRepository;
import com.acme.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.out.InsertCustomerOutPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insert(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));

    }
}
