package com.arantes.hexagonal.adapters;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCostumerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        // Convert Customer to CustomerEntity
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        // Save the updated customer entity
        customerRepository.save(customerEntity);

    }
}
