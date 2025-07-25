package com.arantes.hexagonal.adapters.out.repository.mapper;

import com.arantes.hexagonal.adapters.out.repository.enity.CustomerEntity;
import com.arantes.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer costumer);
    Customer toCustomer(CustomerEntity customerEntity);

}
