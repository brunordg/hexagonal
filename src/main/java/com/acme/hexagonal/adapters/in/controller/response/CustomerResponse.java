package com.acme.hexagonal.adapters.in.controller.response;

import com.acme.hexagonal.application.core.domain.Address;

public record CustomerResponse(String name,
                               AddressResponse address,
                               String cpf,
                               Boolean validCpf) {

}
