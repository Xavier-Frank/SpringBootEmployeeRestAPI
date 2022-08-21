package com.xavi.EmployeeMicroservice.converter;

import com.xavi.EmployeeMicroservice.dto.EmployeeDto;
import com.xavi.EmployeeMicroservice.model.Employee;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/
public class Converter {

    public EmployeeDto convertEntityToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setNationalId(employee.getNationalId());
        employeeDto.setUsername(employeeDto.getUsername());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setRole(employee.getRole());

        return employeeDto;
    }
    public Employee convertDtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setNationalId(employeeDto.getNationalId());
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setRole(employeeDto.getRole());
        return employee;
    }
}
