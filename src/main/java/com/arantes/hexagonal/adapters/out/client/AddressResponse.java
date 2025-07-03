package com.arantes.hexagonal.adapters.out.client;

import lombok.Data;

@Data
public class AddressResponse {
    private String street;
    private String city;
    private String state;
}
