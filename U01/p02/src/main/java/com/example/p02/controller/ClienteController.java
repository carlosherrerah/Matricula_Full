package com.example.p02.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.p02.model.Cliente;
import com.example.p02.service.ClienteService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller     //  @Controller para que funcione mostrarHTML
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(@Autowired ClienteService clienteService) {
        this.clienteService = clienteService;
    }
 
    @GetMapping({ "/all" })
    public ResponseEntity<List<Cliente>> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping({ "/{id}" })
    public ResponseEntity<Optional<Cliente>> getCliente(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getCliente(id));
    }

    @GetMapping("/mostrarHTML")    // @Controller
    public String mostrarHTML(Model model) {
        // Aquí puedes agregar cualquier dato que quieras pasar al HTML
        model.addAttribute("mensaje", "Hola desde el Controller!...");
        return "archivoHTML";
    }

    @GetMapping("/listado")       // @Controller
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.getClientes());
        return "lista"; // lista.html
    }

    @GetMapping("/eliminar/{id}")  // Eliminar Boton
    public String eliminar(@PathVariable Long id, Model model ) {
        if (id > 0 ) {
            clienteService.eliminar(id);
        }
        return "redirect:/listado";   // equivalente a  @GetMapping ("/listado")
    }  
    
    @GetMapping("/form/{id}")      // Editar boton
    public String actualizar(@PathVariable Long id , Model model) {
        Optional<Cliente> cliente = null;
        if (id > 0) {
            cliente = clienteService.getCliente(id);
            System.out.println("No. de cliente: " +  cliente.get().getIdCliente());
        } else {
            return "redirect:listado";
        }

        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        return "form";
    }    
}
    


