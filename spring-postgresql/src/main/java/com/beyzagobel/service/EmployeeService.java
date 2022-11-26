package com.beyzagobel.service;

import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.impl.EmployeeImpl;
import com.beyzagobel.repository.AddressRepository;
import com.beyzagobel.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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

    private final AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = this.modelMapper.map(employeeDTO, Employee.class);
        employee = employeeRepository.save(employee);

        return employee;
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
    public ResponseEntity<Employee> updateEmployee(Long employeeId, EmployeeDTO req) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResolutionException("Employee Not Found For This Id ::" + employeeId));

        Employee employeeDetails = this.modelMapper.map(req, Employee.class);

        employee.setName(employeeDetails.getName());
        employee.setSurname(employeeDetails.getSurname());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setGender(employeeDetails.getGender());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setCreateAt(employeeDetails.getCreateAt());

        return ResponseEntity.ok(employeeRepository.save(employee));


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
