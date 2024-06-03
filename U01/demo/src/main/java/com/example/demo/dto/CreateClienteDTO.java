package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Modelo CreateClienteDTO para crear un cliente")
@Data
public class CreateClienteDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    
    @NotEmpty  // Mas estricto que NotNull
    private String apellido;
    
    @Schema(example = "2014-01-15", description = "Fecha de nacimiento", format = "date-time",pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")    
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
