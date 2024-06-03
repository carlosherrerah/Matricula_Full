package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping({"", "/"})
    public String Saludo() {
        System.out.println("Iniciamos: ");
        return "Hola Mundo Cruel";
    }

}
