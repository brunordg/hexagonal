package com.acme.hexagonal.application.core.usecase;

import com.acme.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import com.acme.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.acme.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;

public class DeleteCustomerByIdUC implements DeleteCustomerByIdInPort {

    private final FindCustomerByIdInPort findCustomerByIdInPort;

    private final DeleteCustomerByIdOutPort deleteCustomerByIdOutPort;

    public DeleteCustomerByIdUC(FindCustomerByIdInPort findCustomerByIdInPort, DeleteCustomerByIdOutPort deleteCustomerByIdOutPort) {
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.deleteCustomerByIdOutPort = deleteCustomerByIdOutPort;
    }

    @Override
    public void delete(String id) {
        this.findCustomerByIdInPort.find(id);

        this.deleteCustomerByIdOutPort.delete(id);
    }
}
