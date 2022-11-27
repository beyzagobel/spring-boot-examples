package com.beyzagobel.service;


import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface EmployeeService {

    Employee createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

     Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException;

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDetails);

    Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException;

    Page<Employee> EMPLOYEE_PAGE(Pageable pageable);

}
