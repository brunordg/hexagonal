package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.adapters.out.repository.CustomerRepository;
import com.acme.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerByIdOutPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
