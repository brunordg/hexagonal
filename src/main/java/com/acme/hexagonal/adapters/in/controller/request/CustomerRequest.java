package com.acme.hexagonal.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(@NotBlank String name, @NotBlank String cpf, @NotBlank String zipCode) {
}
