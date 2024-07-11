package com.example.p03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.p03.exception.ExcepcionRecursoNoEncontrado;
import com.example.p03.model.Employee;
import com.example.p03.service.EmployeeService;
import com.example.p03.service.EmployeeServicio;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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

@GetMapping({"filtrar/{filtro}"})
@ResponseStatus(HttpStatus.OK)
public Collection<Employee> selectEmployees(@PathVariable Boolean filtro) {
  return employeeService.selectEmployees(filtro);
}

  /*
  @GetMapping({ "/total" })
  public List<Map<String, Object>> getTotal() {
    List<Object[]> results = employeeService.total();
    List<Map<String, Object>> response = new ArrayList<>();
    for (Object[] result : results) {
      Map<String, Object> item = new HashMap<>();
      item.put("employeeId", result[0]);
      item.put("orderCount", result[1]);
      response.add(item);
  }
  return response;
  }
  */  

  @GetMapping({ "/all" })
  public ResponseEntity<List<Employee>> getEmployees() {
    return ResponseEntity.ok(employeeService.findAll());
  }

  @GetMapping({ "/todos" })
  @ResponseStatus(HttpStatus.OK)
  public List<Employee> findAll() {
    return employeeService.findAll();
  }

  // @GetMapping({ "/todos" })
  // @ResponseStatus(HttpStatus.OK)
  // public List<EmployeeDTO> findList() {
  // return employeeService.findAll();
  // }

  @GetMapping("/{id}") // http://localhost:8585/employees/1
  public Employee getEmployee(@PathVariable Long id) throws ExcepcionRecursoNoEncontrado {
    return employeeService.getEmployee(id);
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
  @PostMapping // Altas Unicamente
  @ResponseStatus(HttpStatus.CREATED)
  public Employee save(@Valid @RequestBody Employee data) {
    return employeeService.save(data);
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
  public void update(@PathVariable long employeeid, @Valid @RequestBody Employee data)
      throws ExcepcionRecursoNoEncontrado {
    employeeService.update(employeeid, data);
  }

  // @Operation(summary = "Obtiene las Ordenes de un Empleado determinado")
  // @GetMapping("/{employeeId}/orders")
  // @ResponseStatus(HttpStatus.OK)
  // public EmployeeWithOrdersDTO findAllEmployeeOrders(@PathVariable long employeeId) throws ExcepcionRecursoNoEncontrado {
  //   return employeeService.findByIdWithOrders(employeeId);
  // }




}
