package com.acme.hexagonal.application.core.usecase;

import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.acme.hexagonal.application.ports.out.FindCustomerByIdOutPort;

public class FindCustomerByIdUC implements FindCustomerByIdInPort {

    private final FindCustomerByIdOutPort findCustomerByIdOutPort;

    public FindCustomerByIdUC(FindCustomerByIdOutPort findCustomerByIdOutPort) {
        this.findCustomerByIdOutPort = findCustomerByIdOutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
