package com.xavi.EmployeeMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    @Id
    private Long nationalId;
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private Role role;

}
