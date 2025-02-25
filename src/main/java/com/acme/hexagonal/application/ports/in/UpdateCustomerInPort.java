package com.acme.hexagonal.application.ports.in;

import com.acme.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInPort {

    void update(Customer customer, String zipCode);

}
