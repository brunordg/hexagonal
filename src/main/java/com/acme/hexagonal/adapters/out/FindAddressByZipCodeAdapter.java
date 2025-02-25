package com.acme.hexagonal.adapters.out;

import com.acme.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.acme.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.acme.hexagonal.application.core.domain.Address;
import com.acme.hexagonal.application.ports.out.FindAddressByZipCodeOutPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
