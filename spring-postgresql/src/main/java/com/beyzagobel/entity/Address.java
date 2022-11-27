package com.beyzagobel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "isActive")
    private Boolean isActive;

    @Enumerated                          // enum type
    @Column(name = "type_of_address")
    private TypeOfAddress typeOfAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id")
    private Employee employee;

    enum TypeOfAddress{
        HOME_ADDRESS,
        BUSINESS_ADDRESS,
        OTHER
    }

}
