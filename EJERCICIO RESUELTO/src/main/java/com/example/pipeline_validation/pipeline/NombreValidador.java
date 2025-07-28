package com.example.pipeline_validation.pipeline;

import org.springframework.stereotype.Component;

import com.example.pipeline_validation.model.Cliente;

@Component
public class NombreValidador implements Validador {
    @Override
    public void validar(Cliente cliente) {
        if (cliente.getNombre() == null || cliente.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }
}