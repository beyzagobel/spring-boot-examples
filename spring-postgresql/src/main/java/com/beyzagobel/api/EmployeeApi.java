package com.beyzagobel.api;


import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeApi {

    private final EmployeeService employeeService;

    public EmployeeApi(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
            return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees/{id}")
    public Employee createEmployee (@Valid @RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails)
    throws ResourceNotFoundException{
        return employeeService.updateEmployee(employeeId, employeeDetails);

    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        return employeeService.deleteEmployee(employeeId);
    }

    }


