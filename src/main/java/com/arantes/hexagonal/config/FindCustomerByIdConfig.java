package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.out.FindAddressZipCodeAdapter;
import com.arantes.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arantes.hexagonal.application.core.usecase.FindCustomByIdUseCase;
import com.arantes.hexagonal.application.core.usecase.InsertCustumerUseCase;
import com.arantes.hexagonal.application.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomByIdUseCase
    findCustomByIdUseCase(
            FindCustomerByIdOutPutPort findCustomerByIdOutPutPort
    ) {
        return new FindCustomByIdUseCase(findCustomerByIdOutPutPort);
    }
}
