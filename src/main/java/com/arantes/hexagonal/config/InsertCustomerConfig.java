package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.out.FindAddressZipCodeAdapter;
import com.arantes.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arantes.hexagonal.application.core.usecase.InsertCustumerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustumerUseCase
    insertCustumerUseCase(
            FindAddressZipCodeAdapter findAddressZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustumerUseCase(findAddressZipCodeAdapter,insertCustomerAdapter);
    }
}
