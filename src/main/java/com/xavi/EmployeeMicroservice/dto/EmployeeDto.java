package com.xavi.EmployeeMicroservice.dto;

import com.xavi.EmployeeMicroservice.model.Role;
import lombok.Data;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/
@Data
public class EmployeeDto {
    private Long nationalId;
    private String username;
    private String email;
    private Role role;
}
