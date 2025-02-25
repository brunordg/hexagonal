package com.acme.hexagonal.application.ports.out;

import com.acme.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPort {

    Optional<Customer> find(String id);
}
