package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.DeleteCustomerByIdAdapter;
import com.arantes.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.arantes.hexagonal.application.core.usecase.FindCustomByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomByIdUseCase findCustomByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomByIdUseCase, deleteCustomerByIdAdapter);
    }

}
