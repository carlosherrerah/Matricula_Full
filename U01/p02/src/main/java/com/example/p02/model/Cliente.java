package com.example.p02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table (name = "clientes")
public class Cliente {
    @Id
    @Column(name="id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nombre;

    @NotEmpty
    private String apellido;
    
    private LocalDate nacimiento;
    private char genero;
    private Integer edo_civil;
    private boolean estatus;

    @Column(name= "creado_en")
    @Temporal(TemporalType.DATE)
    private LocalDate creadoEn;

    @PrePersist
    public void PrePersist(){
        creadoEn = LocalDate.now();
    }
 
}
