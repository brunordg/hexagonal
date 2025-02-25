package com.acme.hexagonal.application.ports.in;

import com.acme.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInPort {

    Customer find(String id);

}
