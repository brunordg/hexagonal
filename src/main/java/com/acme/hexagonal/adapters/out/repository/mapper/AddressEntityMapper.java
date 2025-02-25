package com.acme.hexagonal.adapters.out.repository.mapper;

import com.acme.hexagonal.adapters.out.repository.entity.AddressEntity;
import com.acme.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressEntityMapper {
    AddressEntity toAddressEntity(Address address);

    Address toAddress(AddressEntity addressEntity);
}
