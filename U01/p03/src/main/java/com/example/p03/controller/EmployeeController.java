package com.example.p03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.p03.dto.CreateEmployeeDTO;
import com.example.p03.dto.EmployeeDTO;
import com.example.p03.dto.EmployeeOrderDTO;
import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.model.Employee;
import com.example.p03.service.EmployeeService;
import com.example.p03.service.EmployeeServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Tag(name = "Endpoints de Empleados", description = "CRUD de empleados")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private EmployeeService employeeService;
  // private EmployeeServicio employeeService; // A manera de clase

  public EmployeeController(@Autowired EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping({ "filtrar/{filtro}" })
  @ResponseStatus(HttpStatus.OK)
  public Collection<Employee> selectEmployees(@PathVariable Boolean filtro) {
    return employeeService.selectEmployees(filtro);
  }

  @GetMapping({ "sales" })
  @ResponseStatus(HttpStatus.OK)
  // public List<Map<String, Object>> saleByEmployee() {
  public List<Object[]> saleByEmployee() {
    return employeeService.saleByEmployee();
  }

  @GetMapping({ "/all" })
  public ResponseEntity<List<Employee>> getEmployees() {
    return ResponseEntity.ok(employeeService.findAll());
  }

  @GetMapping({ "/todos" })
  @ResponseStatus(HttpStatus.OK)
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  @GetMapping({ "/todosDto" })
  @ResponseStatus(HttpStatus.OK)
  public List<EmployeeDTO> findAllDto() {
    return employeeService.findAllDto();
  }

  @GetMapping("/{id}") // http://localhost:8585/employees/1
  public EmployeeDTO getEmployee(@PathVariable Long id) throws ExcepcionRecursoNoEncontrado {
    return employeeService.getEmployeeDTO(id);
  }

  @GetMapping() // http://localhost:8585/employees?id=2
  public Employee getEmpleado(@RequestParam Long id) throws ExcepcionRecursoNoEncontrado {
    return employeeService.getEmployee(id);
  }
  

  /*
   * post: http://localhost:8585/employees
   * {
   * "idemployee": null,
   * "lastName" : "Madrazo",
   * "firstName" : "Pepito",
   * "birthDate" : "1980-03-08",
   * "hireDate" : "2024-07-01",
   * "celular" : "4497654321",
   * "active" : false
   * }
   */
  @PostMapping // Altas
  @ResponseStatus(HttpStatus.CREATED)
  public Employee save(@Valid @RequestBody Employee data) {    // duplicados por Employee
    return employeeService.save(data);
  }

  @PostMapping({ "/alta" })
  @ResponseStatus(HttpStatus.CREATED)
  public EmployeeDTO save(@Valid @RequestBody CreateEmployeeDTO data) {
    return employeeService.saveDTO(data);
  }


  @DeleteMapping("/{id}") // Bajas
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEmployee(@PathVariable Long id) {
    employeeService.delete(id);
  }

  /*
   * PUT: http://localhost:8585/employees/12
   * {
   * "idemployee": 12,
   * "lastName" : "Palos",
   * "firstName" : "Pepito",
   * "birthDate" : "1970-03-08",
   * "hireDate" : "2024-06-06",
   * "celular" : "4497654320",
   * "active" : true
   * }
   */
  @PutMapping("/{employeeid}") // Cambios
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(@PathVariable long employeeid, @Valid @RequestBody Employee data)    // Corregir UpdateEmployeeDTO
      throws ExcepcionRecursoNoEncontrado {
    employeeService.update(employeeid, data);
  }

  @Operation(summary = "Obtiene las Ordenes de un Empleado determinado")
  @GetMapping("/{idEmployee}/orders")
  @ResponseStatus(HttpStatus.OK)
  public EmployeeOrderDTO findAllEmployeeOrders(@PathVariable long idEmployee) throws ExcepcionRecursoNoEncontrado {
  return employeeService.findByIdWithOrders(idEmployee);
  }

}

