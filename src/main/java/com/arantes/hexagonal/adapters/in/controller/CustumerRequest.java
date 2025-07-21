package com.arantes.hexagonal.adapters.in.controller;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustumerRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String zipCode;
}
