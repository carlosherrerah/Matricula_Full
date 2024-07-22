package com.example.p03.dto;

import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Modelo CreateEmployeeDTO para crear un empleado")
@Data
public class CreateEmployeeDTO {
  // idEmployee, hireDate, active

  @Schema(description = "Nombre del Empleado")
  @NotBlank(message = "El nombre del empleado es obligatorio")
  private String lastName;

  private String firstName;

  @Schema(example = "2021-01-15", description = "Fecha de Nacimiento", format = "date-time", pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")  
  private LocalDate birthDate;

  @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$", message = "El celular debe ser de 10 digitos")  
  private String celular;
}
