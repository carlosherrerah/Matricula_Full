package com.example.p03.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Modelo EmployeeDTO para consultar empleado")
@Data
// @AllArgsConstructor
// @NoArgsConstructor
public class EmployeeDTO {
  // idEmployee, hireDate, active

  @Schema(description = "Identificador del empleado", example = "20")
  //@Column(name = "id_employee")
  private long idEmployee;

  @Schema(description = "Apellido del Empleado")
  @NotBlank(message = "El Apellido del empleado es obligatorio")
  private String lastName;

  private String firstName;

  @Schema(example = "2021-01-15", description = "Fecha de Nacimiento", format = "date", pattern = "yyyy-MM-dd")
  //@JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @Schema(description = "Fecha de Contratación", example = "2000-10-20", format = "date-time", pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date hireDate;

  @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
  private String celular;

  private Boolean active;
}
