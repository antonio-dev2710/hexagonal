package com.arantes.hexagonal.adapters.in.consumer;

import com.arantes.hexagonal.application.core.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    //vou receber do kafka o cliente
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;

}
