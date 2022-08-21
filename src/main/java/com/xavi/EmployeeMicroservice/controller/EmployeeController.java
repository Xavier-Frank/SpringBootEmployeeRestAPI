package com.xavi.EmployeeMicroservice.controller;

import com.xavi.EmployeeMicroservice.dto.EmployeeDto;
import com.xavi.EmployeeMicroservice.exceptions.UserAlreadyExistsException;
import com.xavi.EmployeeMicroservice.exceptions.UserNotFoundException;
import com.xavi.EmployeeMicroservice.model.Employee;
import com.xavi.EmployeeMicroservice.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Wednesday 17/08/2022
 **/
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //list all employees in the system
    @GetMapping("/allEmployees")
    @ApiOperation("View all Employees")
    public List<EmployeeDto> employeeDtoList(){
         return employeeService.getAllEmployees();

            /** Introducing spring HATEOAS (Hypermedia As The Engine Of Application State) to present information
             * about the rest api to the client **/
    }

    //add an employee
    @PostMapping("/addEmployee")
    @ApiOperation("Add an Employee")
    public ResponseEntity<Employee> saveEmployee(
            @Validated @RequestBody EmployeeDto employeeDto) throws UserAlreadyExistsException {
       return employeeService.addEmployee(employeeDto);
    }

    //find an employee
    @GetMapping("/findAnEmployee/{id}")
    @ApiOperation("Find an employee using their national id")
    public ResponseEntity<EmployeeDto> findEmployeeByNationalId(
            @PathVariable(value = "id") Long nationalId) throws UserNotFoundException {
        return employeeService.findAnEmployee(nationalId);
    }

    //update an employee
    @PutMapping("/updateEmployeeDetails/{id}")
    @ApiOperation("Update an Employee details")
    public ResponseEntity<EmployeeDto> updateAnEmployee(@PathVariable(value = "id") Long nationalId,
                                                        @RequestBody EmployeeDto employeeDto) throws UserNotFoundException {
        return employeeService.updateEmployee(employeeDto, nationalId);
    }

    //delete an employee
    @DeleteMapping("/deleteAnEmployee/{id}")
    @ApiOperation("Delete an employee")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long nationalId) throws UserNotFoundException {
        return  employeeService.deleteEmployee(nationalId);
    }

}
