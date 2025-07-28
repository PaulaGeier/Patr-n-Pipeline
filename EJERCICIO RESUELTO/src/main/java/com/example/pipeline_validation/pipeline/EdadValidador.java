package com.example.pipeline_validation.pipeline;

import org.springframework.stereotype.Component;

import com.example.pipeline_validation.model.Cliente;

@Component
public class EdadValidador implements Validador {
    @Override
    public void validar(Cliente cliente) {
        if (cliente.getEdad() < 18) {
            throw new IllegalArgumentException("Debe ser mayor de 18 años.");
        }
    }
}