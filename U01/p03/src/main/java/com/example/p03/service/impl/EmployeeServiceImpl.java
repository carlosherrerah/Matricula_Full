package com.example.p03.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.time.LocalDate; 

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.p03.dto.CreateEmployeeDTO;
import com.example.p03.dto.EmployeeDTO;
import com.example.p03.dto.EmployeeOrderDTO;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.mapper.EmployeeMapper;
import com.example.p03.model.Employee;
import com.example.p03.repository.EmployeeRepository;
import com.example.p03.service.EmployeeService;

import jakarta.validation.Valid;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private EmployeeRepository employeeRepository;
  private EmployeeMapper employeeMapper;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
    this.employeeRepository = employeeRepository;
    this.employeeMapper = employeeMapper;
  }

  @Override
  public Collection<Employee> selectEmployees(Boolean filtro) {
    return this.employeeRepository.selectEmployees(filtro);
  }

  @Override
  public List<Object[]> saleByEmployee() {
    // public List<Map<String, Object>> saleByEmployee() {
    return this.employeeRepository.saleByEmployee();
  }

  @Override
  public List<Employee> findAll() {
    List<Employee> data = employeeRepository.findAll();
    return data;
  }

  @Override
  public List<EmployeeDTO> findAllDto() {
    List<Employee> data = employeeRepository.findAll();
    List<EmployeeDTO> result = employeeMapper.toDTO(data);
    return result;
    // return employeeMapper.toDTO(data); // Error
  }

  @Override
  public Employee getEmployee(long employeeid) throws ExcepcionRecursoNoEncontrado {
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeid);
    if (!optionalEmployee.isPresent()) {
      throw new ExcepcionRecursoNoEncontrado("Employee not found: " + employeeid);
    }
    return optionalEmployee.get();
  }

  @Override
  public EmployeeDTO getEmployeeDTO(long employeeid) throws ExcepcionRecursoNoEncontrado {
    Employee optionalEmployee = employeeRepository.findById(employeeid)
        .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("Employee not found: " + employeeid));
    return employeeMapper.toDTO(optionalEmployee);
  }

  // Insert
  @Transactional
  public Employee save(Employee data) {
    Employee result = employeeRepository.save(data);
    return result;
  }

  // Insert
  @Override
  public EmployeeDTO saveDTO(CreateEmployeeDTO data) {
    Employee model = employeeMapper.toModel(data);
    model.setHireDate(LocalDate.now());
    model.setActive(true);
    Employee result = employeeRepository.save(model);
    return employeeMapper.toDTO(result);
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

  @Override
  public EmployeeOrderDTO findByIdWithOrders(long employeeId) throws ExcepcionRecursoNoEncontrado {
    EmployeeOrderDTO employeeOrderDTO; 
    Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);

    if (!optionalEmployee.isPresent()) {
        throw new ExcepcionRecursoNoEncontrado("Employee not found: " + employeeId);
    }
    employeeOrderDTO = optionalEmployee.stream().map(employeeMapper::toDTOWithOrders).toList().get(0);
    return employeeOrderDTO;
}


}
