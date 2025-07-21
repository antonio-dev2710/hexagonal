package com.arantes.hexagonal.adapters;

import com.arantes.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.arantes.hexagonal.adapters.out.repository.CustomerRepository;
import com.arantes.hexagonal.application.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void delete(String id){
        customerRepository.deleteById(id);
    }
}
