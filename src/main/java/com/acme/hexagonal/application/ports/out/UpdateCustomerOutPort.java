package com.acme.hexagonal.application.ports.out;

import com.acme.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutPort {

    void update(Customer customer);

}
