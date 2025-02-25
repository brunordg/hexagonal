package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.application.ports.out.SendCpfForValidationOutPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
        this.kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
