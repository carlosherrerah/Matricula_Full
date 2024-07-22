package com.example.p03.dto;

import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
public class EmployeeDTO {

  private Long idEmployee;

  private String lastName;

  private String firstName;
  
  @JsonFormat(pattern = "yyyy-MM-dd") 
  private LocalDate birthDate;

  @JsonFormat(pattern = "yyyy-MM-dd") 
  private LocalDate hireDate;

  private String celular;

  private Boolean active;

}
