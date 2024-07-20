package com.example.p03.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class OrderDTOsimple {
  private Long idOrder;

  //private EmployeeDTO employee;
  private Long idEmployee;   // aparece null

  @JsonFormat(pattern = "yyyy-MM-dd") 
  private LocalDate orderDate;
  
}
