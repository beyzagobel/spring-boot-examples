package com.beyzagobel.api;


import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeApi {

    private final EmployeeService employeeImpl;

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeImpl.getAllEmployees());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
            return ResponseEntity.ok(employeeImpl.getEmployeeById(employeeId));
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee (@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeImpl.createEmployee(employeeDTO));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                    @RequestBody EmployeeDTO employeeDetails) {
        return ResponseEntity.ok(employeeImpl.updateEmployee(employeeId, employeeDetails));

    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException{
        return employeeImpl.deleteEmployee(employeeId);
    }

}


