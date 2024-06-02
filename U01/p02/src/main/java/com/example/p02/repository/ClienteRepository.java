package com.example.p02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.p02.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
