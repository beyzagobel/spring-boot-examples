package com.beyzagobel.impl;

import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Address;
import com.beyzagobel.entity.Employee;
import com.beyzagobel.exception.ResourceNotFoundException;
import com.beyzagobel.repository.AddressRepository;
import com.beyzagobel.repository.EmployeeRepository;
import com.beyzagobel.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = modelMapper.map(employeeDTO, Employee.class);

        List<Address> addressList = new ArrayList<>();
        employee.getAddressList().forEach(item ->{
            Address address = new Address();
            address.setAddress(item.getAddress());
            address.setTypeOfAddress(item.getTypeOfAddress());
            address.setIsActive(item.getIsActive());
            addressList.add(address);

        });
        addressRepository.saveAll(addressList);
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For This Id ::" + employeeId));
        return employee;
    }


    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO req) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResolutionException("Employee Not Found For This Id ::" + employeeId));

        // convert DTO to entitiy
        Employee employeeDetails = this.modelMapper.map(req, Employee.class);

        employee.setName(employeeDetails.getName());
        employee.setSurname(employeeDetails.getSurname());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setGender(employeeDetails.getGender());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        employee.setCreateAt(employeeDetails.getCreateAt());

        List<Address> addressList = new ArrayList<>();

        employeeDetails.getAddressList().forEach(item ->{
            Address address = new Address();
            address.setAddress(item.getAddress());
            address.setTypeOfAddress(item.getTypeOfAddress());
            address.setIsActive(item.getIsActive());
            addressList.add(address);

        });
        // employee.setAddressList(addressList);
        addressRepository.saveAll(addressList);
        employeeRepository.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);


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

    @Override
    public Page<Employee> EMPLOYEE_PAGE(Pageable pageable) {
        return null;
    }
}
