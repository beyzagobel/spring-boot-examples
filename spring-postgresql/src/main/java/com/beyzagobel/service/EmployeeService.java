package com.beyzagobel.service;

import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.impl.EmployeeImpl;
import com.beyzagobel.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService implements EmployeeImpl {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For This Id ::" + employeeId));
        return ResponseEntity.ok(employee);
    }


    @Override
    public ResponseEntity<Employee> updateEmployee(Long employeeId, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResolutionException("Employee Not Found For This Id ::" + employeeId));

        employee.setName(employeeDetails.getName());
        employee.setAge(employeeDetails.getAge());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setGender(employeeDetails.getGender());
        employee.setSalary(employeeDetails.getSalary());

        final Employee updateEmployee = employeeRepository.save(employee);

        return ResponseEntity.ok(updateEmployee);
    }

    @Override
    public Map<String, Boolean> deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
