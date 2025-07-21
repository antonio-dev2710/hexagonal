package com.arantes.hexagonal.adapters.in.controller.mapper;

import com.arantes.hexagonal.adapters.in.controller.CustumerRequest;
import com.arantes.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.arantes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustumerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
