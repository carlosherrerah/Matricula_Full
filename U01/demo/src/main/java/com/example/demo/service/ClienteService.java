package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

import java.util.*;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
   
    public List<Cliente> getClientes() {
        
        //List<Cliente> clientes ;
        //clientes = clienteRepository.findAll();
        //Collections.sort(clientes, Comparator.comparing(Cliente::getNombre));
        //return clientes;
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public void borrar(Long id) {
        clienteRepository.deleteById(id);
    }

/*
    public List<Cliente> salvar(Cliente cliente) {
        return clienteRepository.save(cliente);  // Altas y Cambios
    }
*/
    
}
