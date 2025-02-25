package com.acme.hexagonal.adapters.out.client.mapper;

import com.acme.hexagonal.adapters.out.client.response.AddressResponse;
import com.acme.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
