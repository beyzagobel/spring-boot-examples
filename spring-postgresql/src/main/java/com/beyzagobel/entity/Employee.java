package com.beyzagobel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "e_id", nullable = false)
    private Long id;

    @Column(name = "e_name", nullable = false)
    private String name;

    @Column(name = "e_gender", nullable = false)
    private String gender;

    @Column(name = "e_dept", nullable = false)
    private String department;

    @Column(name = "e_age")
    private Integer age;

    @Column(name = "e_salary",nullable = false)
    private Integer salary;

   
}
