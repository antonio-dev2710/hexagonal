package com.arantes.hexagonal.adapters.in.controller.response;

import com.arantes.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {
    private String id;
    private String name;
    private Address address;
    private String cpf;
    private Boolean isValidCpf;
}
