package com.example.p03.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.*;

@Data
@Entity
@Table(name = "employees")
public class Employee {
  @Id
  @Column(name = "id_employee")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idEmployee;

  @NotBlank(message = "No puede estar vacio")
  private String lastName;

  private String firstName;
  
  @Temporal(TemporalType.DATE)
  private LocalDate birthDate;
  
  @Column(name = "hire_date")
  @Temporal(TemporalType.DATE)
  private LocalDate hireDate;

  @NotEmpty(message = "El celular no puede estar vacio.")  
  @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
  private String celular;
  
  private boolean status;

  @PrePersist
  public void PrePersist() {
    hireDate = LocalDate.now();
  }

  //@OneToMany(mappedBy = "employee")
  //private List<Order> orders;
  //private List<Order> orders = new ArrayList<>();  
  
}
