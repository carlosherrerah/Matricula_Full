package com.example.p03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.p03.model.Employee;
import java.util.*;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
  // Java.ventas-develop_old
  //@Query(value = "SELECT * FROM employee WHERE id_employee = ?1", nativeQuery = true)
  //@Query("SELECT o.employee.id, COUNT(o) FROM orders o GROUP BY o.employee.id")
  //@Query(value = "SELECT o.id_employee, COUNT(*) FROM orders o GROUP BY o.id_employee")
  //List<Object[]> ordersByEmployee();

@Query(value ="Select * from employees where active = ?1", nativeQuery=true)
Collection<Employee> selectEmployees(Boolean filtro);

  // https://www.baeldung.com/spring-data-jpa-query
  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  // https://www.geeksforgeeks.org/spring-data-jpa-query-annotation-with-example/


}