package com.example.p03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Endpoint de Inicio", description = "Bienvenido Bro")
@RestController
@RequestMapping("/")
public class SaludoController {
    @GetMapping()
    public String saludar() {
        return "Welcome to FullStack!..."; // saludos.html
    }

}
