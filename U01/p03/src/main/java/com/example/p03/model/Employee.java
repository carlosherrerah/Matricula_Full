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
  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name") 
  private String firstName;
  
  @Temporal(TemporalType.DATE)
  @Column(name = "birth_date")
  private LocalDate birthDate;
  
  @Column(name = "hire_date")
  @Temporal(TemporalType.DATE)
  private LocalDate hireDate;

  @NotEmpty(message = "El celular no puede estar vacio.")  
  @Pattern(regexp = "^(\\d{3}[-]?){2}\\d{4}$")
  private String celular;
  
  private boolean active;

  @PrePersist
  public void PrePersist() {
    hireDate = LocalDate.now();
  }

  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)   // atributo de Orders -> employee
  private List<Order> orders = new ArrayList<>();  
  
}
