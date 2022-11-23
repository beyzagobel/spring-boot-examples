package com.beyzagobel.impl;


import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;


public interface EmployeeImpl {



    Employee createEmployee(EmployeeDTO employeeDTO);

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    ResponseEntity<Employee> updateEmployee(Long employeeId, EmployeeDTO employeeDetails);

    Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;

}
