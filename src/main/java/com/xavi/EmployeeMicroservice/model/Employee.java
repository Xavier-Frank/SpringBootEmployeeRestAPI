package com.xavi.EmployeeMicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee extends RepresentationModel<Employee> {
    @Id
    private Long nationalId;
    @Column(nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
