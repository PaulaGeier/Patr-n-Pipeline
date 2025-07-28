package com.example.pipeline_validation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pipeline_validation.model.Cliente;
import com.example.pipeline_validation.pipeline.PipelineService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final PipelineService pipelineService;

    public ClienteController(PipelineService pipelineService) {
        this.pipelineService = pipelineService;
    }

    @PostMapping
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        try {
            pipelineService.procesar(cliente);
            return ResponseEntity.ok("Cliente validado y creado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}