package com.example.p02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SaludoController {

    @GetMapping("/") 
    public String saludar(Model model) {
      model.addAttribute("mensaje", "Hola desde el Controller!...");
      return "saludos";    // saludos.html
    }

}
