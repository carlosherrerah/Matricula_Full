package com.example.p03.service;

import java.util.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.model.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

  public List<Employee> findAll();

  public Employee getEmployee(long employeeid) throws ExcepcionRecursoNoEncontrado;

  public Employee save(@Valid @RequestBody Employee data);  // Altas

  public void delete(long employeeid);  // Bajas

  public void update(long employeeid, Employee data) throws ExcepcionRecursoNoEncontrado;  // Cambios

  public Collection<Employee> selectEmployees(Boolean filtro);
  
  // public List<Object[]> total();

}
