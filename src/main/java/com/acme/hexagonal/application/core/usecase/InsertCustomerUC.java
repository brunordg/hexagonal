package com.acme.hexagonal.application.core.usecase;

import com.acme.hexagonal.application.core.domain.Customer;
import com.acme.hexagonal.application.ports.in.InsertCustomerInPort;
import com.acme.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import com.acme.hexagonal.application.ports.out.InsertCustomerOutPort;
import com.acme.hexagonal.application.ports.out.SendCpfForValidationOutPort;

public class InsertCustomerUC implements InsertCustomerInPort {

    private final FindAddressByZipCodeOutPort findAddressByZipCodeOutPort;

    private final InsertCustomerOutPort insertCustomerOutPort;

    private final SendCpfForValidationOutPort sendCpfForValidationOutPort;


    public InsertCustomerUC(FindAddressByZipCodeOutPort findAddressByZipCodeOutPort, InsertCustomerOutPort insertCustomerOutPort, SendCpfForValidationOutPort sendCpfForValidationOutPort) {
        this.findAddressByZipCodeOutPort = findAddressByZipCodeOutPort;
        this.insertCustomerOutPort = insertCustomerOutPort;
        this.sendCpfForValidationOutPort = sendCpfForValidationOutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutPort.find(zipCode);

        customer.setAddress(address);

        insertCustomerOutPort.insert(customer);

        this.sendCpfForValidationOutPort.send(customer.getCpf());
    }

}
