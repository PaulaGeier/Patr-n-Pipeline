package com.example.pipeline_validation.pipeline;

import org.springframework.stereotype.Service;

import com.example.pipeline_validation.model.Cliente;

import java.util.List;

@Service
public class PipelineService {
    private final List<Validador> validadores;

    public PipelineService(List<Validador> validadores) {
        this.validadores = validadores;
    }

    public void procesar(Cliente cliente) {
        for (Validador validador : validadores) {
            validador.validar(cliente);
        }
    }
}