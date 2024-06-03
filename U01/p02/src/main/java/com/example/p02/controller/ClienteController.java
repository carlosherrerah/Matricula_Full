package com.example.p02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.p02.model.Cliente;
import com.example.p02.service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ClienteController {
    private final ClienteService clienteService;
    
    public ClienteController(@Autowired ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping({ "/all" })
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }    

    
}
