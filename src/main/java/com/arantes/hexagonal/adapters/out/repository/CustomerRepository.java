package com.arantes.hexagonal.adapters.out.repository;

import com.arantes.hexagonal.adapters.out.repository.enity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <CustomerEntity, String> {
    // This interface will automatically provide CRUD operations for CustomerEntity
    // Additional custom query methods can be defined here if needed
}
