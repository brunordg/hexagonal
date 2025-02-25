package com.acme.hexagonal.adapters.in.consumer;

import com.acme.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.acme.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.acme.hexagonal.application.ports.in.UpdateCustomerInPort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private final UpdateCustomerInPort updateCustomerInPort;

    private final CustomerMessageMapper customerMessageMapper;

    public ReceiveValidatedCpfConsumer(UpdateCustomerInPort updateCustomerInPort, CustomerMessageMapper customerMessageMapper) {
        this.updateCustomerInPort = updateCustomerInPort;
        this.customerMessageMapper = customerMessageMapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "${spring.application.name}")
    public void receive(CustomerMessage customerMessage) {
        this.updateCustomerInPort.update(customerMessageMapper.toCustomer(customerMessage), customerMessage.zipCode());
    }

}
