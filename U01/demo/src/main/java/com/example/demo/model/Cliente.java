package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    
    private String nombre;
    
    @NotEmpty
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
