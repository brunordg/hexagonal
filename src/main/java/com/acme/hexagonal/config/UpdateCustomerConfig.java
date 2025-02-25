package com.acme.hexagonal.config;

import com.acme.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.acme.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.acme.hexagonal.application.core.usecase.FindCustomerByIdUC;
import com.acme.hexagonal.application.core.usecase.UpdateCustomerUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUC updateCustomerUC(FindCustomerByIdUC findCustomerByIdUC,
                                             FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                             UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUC(findCustomerByIdUC, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
