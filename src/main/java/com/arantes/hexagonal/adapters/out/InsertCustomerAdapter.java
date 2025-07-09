package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.InsertCostumerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCustomerAdapter implements InsertCostumerOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer costumer) {
        // Convert Costumer to CustomerEntity
        var customerEntity = customerEntityMapper.toCustomerEntity(costumer);
        customerRepository.save(customerEntity);

    }
}
