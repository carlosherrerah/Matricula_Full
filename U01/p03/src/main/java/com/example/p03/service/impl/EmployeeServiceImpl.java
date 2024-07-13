package com.example.p03.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.model.Employee;
import com.example.p03.repository.EmployeeRepository;
import com.example.p03.service.EmployeeService;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Collection<Employee> selectEmployees(Boolean filtro) {
    return this.employeeRepository.selectEmployees(filtro);
  }

  @Override
  public List<Object []>  saleByEmployee() {
  //public List<Map<String, Object>> saleByEmployee() {
    return this.employeeRepository.saleByEmployee();
  }

  @Override
  public List<Employee> findAll() {
    List<Employee> data = employeeRepository.findAll();
    return data;
  }

  @Override
  public Employee getEmployee(long employeeid) throws ExcepcionRecursoNoEncontrado {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeid);
    if (!optionalEmployee.isPresent()) {
      throw new ExcepcionRecursoNoEncontrado("Employee not found: " + employeeid);
    }
    return optionalEmployee.get();
  }

  // Insert
  @Transactional
  public Employee save(@Valid Employee data) {
    Employee result = employeeRepository.save(data);
    return result;
  }

  // delete
  @Override
  public void delete(long employeeid) {
      employeeRepository.deleteById(employeeid);
  }

  // update  
  @Override
  public void update(long employeeid, Employee data) throws ExcepcionRecursoNoEncontrado {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeid);
    if (!optionalEmployee.isPresent()) {
      throw new ExcepcionRecursoNoEncontrado("Employee not found: " + employeeid);
    }
    Employee employee = optionalEmployee.get();
    employee.setLastName(data.getLastName());
    employee.setFirstName(data.getFirstName());
    employee.setBirthDate(data.getBirthDate());
    employee.setHireDate(data.getHireDate());
    employee.setCelular(data.getCelular());
    employee.setActive(data.isActive());
    employeeRepository.save(employee);
  }

}
