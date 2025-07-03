package com.arantes.hexagonal.application.ports.out;

import com.arantes.hexagonal.application.core.domain.Costumer;

public interface InsertCostumerOutputPort {
    void insert(Costumer costumer);
}
