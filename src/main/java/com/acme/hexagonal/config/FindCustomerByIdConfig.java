package com.acme.hexagonal.config;

import com.acme.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.acme.hexagonal.application.core.usecase.FindCustomerByIdUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUC findCustomerByIdUC(FindCustomerByIdAdapter findCustomerByIdAdapter) {
        return new FindCustomerByIdUC(findCustomerByIdAdapter);
    }
}
