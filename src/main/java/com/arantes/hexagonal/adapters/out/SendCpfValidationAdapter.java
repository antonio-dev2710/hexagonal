package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfForValidationOutputPort {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("cpf-validation",cpf);
    }
}
