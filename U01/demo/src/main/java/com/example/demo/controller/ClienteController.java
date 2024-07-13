package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.CreateClienteDTO;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Tag(name = "Endpoints de Clientes", description = "CRUD de Clientes")
@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(@Autowired ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping({ "/all" })
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getCliente(id));
    }

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.getClientes());
        return "lista";   // lista.html
    }

    @PostMapping("/listar")
    public ModelAndView listar(@Valid Cliente cliente) {
        ModelAndView mav = new ModelAndView("listas"); 

        mav.addObject("titulo", "Listado de clientes");
        mav.addObject("clientes", clienteService.getClientes());
        return mav;   // lista.html
    }


/*    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Cliente>> salvar(@Valid @RequestBody Cliente data) {
        return clienteService.salvar(data);
    }
*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCliente(@PathVariable Long id) {
        clienteService.borrar(id);
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        if (id > 0) {
            clienteService.borrar(id);
        }
        return "Registro Eliminado";
    }

}
