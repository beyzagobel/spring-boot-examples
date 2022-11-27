package com.beyzagobel.impl;

import com.beyzagobel.dto.AddressDTO;
import com.beyzagobel.dto.EmployeeDTO;
import com.beyzagobel.entity.Address;
import com.beyzagobel.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface AddressImpl {

    ResponseEntity<Address> createAddress(AddressDTO employeeDTO);

    ResponseEntity<List<Address>> getAllAddress();

    ResponseEntity<Address> updateAddress(Long addressId, AddressDTO addressDTO);

    Map<String, Boolean> deleteAddress(Long addressId) throws ResourceNotFoundException;

    Page<EmployeeDTO> gelAllAddress(Pageable pageable);

}
