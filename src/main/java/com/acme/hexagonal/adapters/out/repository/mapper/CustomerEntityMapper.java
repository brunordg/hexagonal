package com.acme.hexagonal.adapters.out.repository.mapper;

import com.acme.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.acme.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AddressEntityMapper.class})
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);



}
