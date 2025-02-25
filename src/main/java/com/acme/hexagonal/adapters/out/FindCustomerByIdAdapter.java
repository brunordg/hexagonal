package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.adapters.out.repository.CustomerRepository;
import com.acme.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.out.FindCustomerByIdOutPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);

        return customerEntity.map(customerEntityMapper::toCustomer);

    }
}
