package com.acme.hexagonal.application.ports.out;

import com.acme.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutPort {

    Address find(String zipCode);

}
