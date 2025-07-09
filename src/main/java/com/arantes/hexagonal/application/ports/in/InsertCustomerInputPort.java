package com.arantes.hexagonal.application.ports.in;

import com.arantes.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    //o caso de uso precisa implementar essa porta para acessar o mesmo
    void insert(Customer customer, String zipCode);
}
