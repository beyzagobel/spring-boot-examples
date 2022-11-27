package com.beyzagobel.dto;

import com.beyzagobel.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String gender;
    private String department;
    private Integer salary;
    private Date createAt;
    private List<Address> addressList;

}
