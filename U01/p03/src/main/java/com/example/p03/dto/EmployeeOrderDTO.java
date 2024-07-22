package com.example.p03.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EmployeeOrderDTO {
  private Long idEmployee;

  private String lastName;

  private String firstName;

  @JsonFormat(pattern = "yyyy-MM-dd")   
  private LocalDate birthDate;

  @JsonFormat(pattern = "yyyy-MM-dd") 
  private LocalDate hireDate;

  private String celular;

  private Boolean active;

  
  private List<OrderDTO> orders;
  
}
