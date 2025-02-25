package com.acme.hexagonal.config;

import com.acme.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.acme.hexagonal.application.core.usecase.DeleteCustomerByIdUC;
import com.acme.hexagonal.application.core.usecase.FindCustomerByIdUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUC deleteCustomerByIdUC(FindCustomerByIdUC findCustomerByIdUC, DeleteCustomerAdapter deleteCustomerAdapter) {
        return new DeleteCustomerByIdUC(findCustomerByIdUC, deleteCustomerAdapter);
    }

}
