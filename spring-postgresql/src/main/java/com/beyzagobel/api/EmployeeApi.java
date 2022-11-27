package com.beyzagobel.api;


import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.impl.EmployeeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeApi {

    private final EmployeeImpl employeeImpl;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeImpl.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
            return employeeImpl.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee (@RequestBody EmployeeDTO employeeDTO){
        return employeeImpl.createEmployee(employeeDTO);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                    @RequestBody EmployeeDTO employeeDetails) {
        return employeeImpl.updateEmployee(employeeId, employeeDetails);

    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        return employeeImpl.deleteEmployee(employeeId);
    }

}


