package com.arantes.hexagonal.application.ports.out;

import com.arantes.hexagonal.application.core.domain.Customer;

public interface InsertCostumerOutputPort {
    void insert(Customer costumer);
}
