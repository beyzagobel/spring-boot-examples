package com.beyzagobel.impl;


import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeImpl {

    Employee createEmployee(Employee employee);

    ResponseEntity<List<Employee>> getAllEmployees();

    ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails);

    Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;

}
