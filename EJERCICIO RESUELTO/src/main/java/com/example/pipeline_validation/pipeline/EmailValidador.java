package com.example.pipeline_validation.pipeline;

import org.springframework.stereotype.Component;

import com.example.pipeline_validation.model.Cliente;

import java.util.regex.Pattern;

@Component
public class EmailValidador implements Validador {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    @Override
    public void validar(Cliente cliente) {
        if (cliente.getEmail() == null || !EMAIL_PATTERN.matcher(cliente.getEmail()).matches()) {
            throw new IllegalArgumentException("Email inválido.");
        }
    }
}