package com.acme.hexagonal.application.ports.out;

import com.acme.hexagonal.application.core.domain.Customer;

public interface InsertCustomerOutPort {

    void insert(Customer customer);

}
