package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    
    @NotEmpty  // Mas estricto que NotNull
    private String apellido;
    
    private LocalDate nacimiento;
    
    private char genero;

    @Column(name = "edo_civil")
    private Integer edoCivil;
    
    private boolean estatus;

    @Column(name = "creado_en")
    @Temporal(TemporalType.DATE)
    private LocalDate creadoEn;

    @PrePersist
    public void prePersist() {
        creadoEn = LocalDate.now();
    }

    
}
