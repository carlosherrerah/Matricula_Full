package com.example.p02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
    
    @GetMapping("/")
    public String saludo() {
        System.out.println("Iniciamos: ");
        return "Hola Mundo Cruel";
        
    }


}
