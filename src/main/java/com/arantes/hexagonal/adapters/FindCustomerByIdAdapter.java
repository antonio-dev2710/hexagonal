package com.arantes.hexagonal.adapters;

import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class FindCustomerByIdAdapter implements FindCustomerByIdOutPutPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
