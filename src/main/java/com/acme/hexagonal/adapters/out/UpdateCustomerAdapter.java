package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.adapters.out.repository.CustomerRepository;
import com.acme.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.out.UpdateCustomerOutPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerMapper.toCustomerEntity(customer));
    }
}
