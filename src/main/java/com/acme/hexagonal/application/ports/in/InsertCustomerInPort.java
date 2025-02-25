package com.acme.hexagonal.application.ports.in;

import com.acme.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInPort {

    void insert(Customer customer, String zipCode);

}
