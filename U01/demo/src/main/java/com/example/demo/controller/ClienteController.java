package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

import java.util.*;

@Controller
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
