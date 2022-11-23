package com.beyzagobel.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeDTO implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String gender;
    private String department;
    private Integer salary;
    private Date createAt;

}
