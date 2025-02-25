package com.acme.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutPort {

    void delete(String id);
}
