package com.acme.hexagonal.config;

import com.acme.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.acme.hexagonal.adapters.out.InsertCustomerAdapter;
import com.acme.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.acme.hexagonal.application.core.usecase.InsertCustomerUC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUC insertCustomerUC(FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                             InsertCustomerAdapter insertCustomerAdapter,
                                             SendCpfValidationAdapter sendCpfValidationAdapter) {

        return new InsertCustomerUC(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }

}
