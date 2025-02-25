package com.acme.hexagonal.adapters.in.consumer.message;


public record CustomerMessage(String id, String name, String zipCode, String cpf, Boolean validCpf) {


}
