package com.example.p03.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.p03.dto.CreateEmployeeDTO;
import com.example.p03.dto.EmployeeDTO;
import com.example.p03.dto.EmployeeOrderDTO;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.model.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

  public List<Employee> findAll();

  public List<EmployeeDTO> findAllDto();

  public Employee getEmployee(long employeeid)       throws ExcepcionRecursoNoEncontrado;
  public EmployeeDTO getEmployeeDTO(long employeeid) throws ExcepcionRecursoNoEncontrado;

  public Employee save(Employee data);                 // Altas
  public EmployeeDTO saveDTO(CreateEmployeeDTO data);  // Altas

  public void delete(long employeeid); // Bajas

  public void update(long employeeid, Employee data) throws ExcepcionRecursoNoEncontrado; // Cambios

  public Collection<Employee> selectEmployees(Boolean filtro);

  // public List<Map<String, Object>> saleByEmployee();
  public List<Object[]> saleByEmployee();

  public EmployeeOrderDTO findByIdWithOrders(long employeeId) throws ExcepcionRecursoNoEncontrado;
  
}
