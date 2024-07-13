package com.example.p03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.p03.model.Employee;
import java.util.*;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  @Query(value = "Select * from employees where active = ?1", nativeQuery = true)
  Collection<Employee> selectEmployees(Boolean filtro);

  // @Query(value ="Select id_employee, last_name from employees; ", nativeQuery=true)
  @Query(value = "select last_name,  " +
      "count( distinct id_order) ordenes, " +
      "round(sum(quantity*unit_price*(1-discount)),0) ventas " +
      "from employees natural join orders " +
      "               natural join orderdetails " +
      "group by last_name; ", nativeQuery = true)
  List<Object[]> saleByEmployee();
  // List<Map<String, Object>> saleByEmployee();

  
  // https://www.baeldung.com/spring-data-jpa-query
  // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
  // https://www.geeksforgeeks.org/spring-data-jpa-query-annotation-with-example/

}