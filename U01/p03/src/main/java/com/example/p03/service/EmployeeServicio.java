package com.example.p03.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.p03.model.Employee;
import com.example.p03.repository.EmployeeRepository;

@Service
public class EmployeeServicio {
      private EmployeeRepository employeeRepository;

      public EmployeeServicio(EmployeeRepository employeeRepository) {
          this.employeeRepository = employeeRepository;
      } 
      
      public List<Employee> findAll() {
        List<Employee> data = employeeRepository.findAll();
        return data;
    }
}
