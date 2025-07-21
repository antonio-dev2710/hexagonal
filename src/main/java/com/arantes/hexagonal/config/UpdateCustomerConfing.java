package com.arantes.hexagonal.config;

import com.arantes.hexagonal.adapters.FindCustomerByIdAdapter;
import com.arantes.hexagonal.adapters.UpdateCostumerAdapter;
import com.arantes.hexagonal.adapters.out.FindAddressZipCodeAdapter;
import com.arantes.hexagonal.application.core.usecase.FindCustomByIdUseCase;
import com.arantes.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.arantes.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfing {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomByIdUseCase findCustomByIdUseCase,
            FindAddressZipCodeAdapter findAddressZipCodeAdapter,
            UpdateCostumerAdapter updateCostumerAdapter) {
        return new UpdateCustomerUseCase(findCustomByIdUseCase,
                findAddressZipCodeAdapter, updateCostumerAdapter);
    }
}
