package com.acme.hexagonal.adapters.in.controller;

import com.acme.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.acme.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.acme.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.acme.hexagonal.application.ports.in.DeleteCustomerByIdInPort;
import com.acme.hexagonal.application.ports.in.FindCustomerByIdInPort;
import com.acme.hexagonal.application.ports.in.InsertCustomerInPort;
import com.acme.hexagonal.application.ports.in.UpdateCustomerInPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final InsertCustomerInPort insertCustomerInPort;

    private final FindCustomerByIdInPort findCustomerByIdInPort;

    private final UpdateCustomerInPort updateCustomerInPort;

    private final DeleteCustomerByIdInPort deleteCustomerByIdInPort;

    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerInPort insertCustomerInPort,
                              FindCustomerByIdInPort findCustomerByIdInPort,
                              UpdateCustomerInPort updateCustomerInPort,
                              DeleteCustomerByIdInPort deleteCustomerByIdInPort,
                              CustomerMapper customerMapper) {

        this.insertCustomerInPort = insertCustomerInPort;
        this.findCustomerByIdInPort = findCustomerByIdInPort;
        this.updateCustomerInPort = updateCustomerInPort;
        this.deleteCustomerByIdInPort = deleteCustomerByIdInPort;
        this.customerMapper = customerMapper;
    }


    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        insertCustomerInPort.insert(customerMapper.toCustomer(customerRequest), customerRequest.zipCode());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable String id) {
        var customer = findCustomerByIdInPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);

        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updae(@PathVariable final String id, @Valid @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);

        this.updateCustomerInPort.update(customer, customerRequest.zipCode());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {

        this.deleteCustomerByIdInPort.delete(id);

        return ResponseEntity.noContent().build();
    }
}
