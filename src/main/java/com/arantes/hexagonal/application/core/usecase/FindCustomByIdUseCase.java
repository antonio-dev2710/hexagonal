package com.arantes.hexagonal.application.core.usecase;


import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;

public class FindCustomByIdUseCase  implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCustomByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }
    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPutPort.find(id).orElseThrow(()-> new RuntimeException("Customer not found"));

    }
}
