package com.acme.hexagonal.application.core.usecase;

import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.acme.hexagonal.application.ports.in.UpdateCustomerInPort;
import com.acme.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.acme.hexagonal.application.ports.out.UpdateCustomerOutPort;

public class UpdateCustomerUC implements UpdateCustomerInPort {

    private final FindCustomerByIdInPort findCustomerByIdInPort;

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    private final UpdateCustomerOutPort updateCustomerOutPort;

    public UpdateCustomerUC(FindCustomerByIdInPort findCustomerByIdInPort, FindAddressByZipCodeOutPort findAddressByZipCodeOutPort, UpdateCustomerOutPort updateCustomerOutPort) {
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.updateCustomerOutPort = updateCustomerOutPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        this.findCustomerByIdInPort.find(customer.getId());

        var address = this.findAddressByZipCodeOutPort.find(zipCode);

        customer.setAddress(address);

        this.updateCustomerOutPort.update(customer);
    }

}
