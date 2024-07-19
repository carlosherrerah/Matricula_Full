package com.example.p03.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class OrderDTO {
  private Long idOrder;

  //private EmployeeDTO employee;
  private Long idEmployee;

  @JsonFormat(pattern = "yyyy-MM-dd") 
  private LocalDate orderDate;
  
}
