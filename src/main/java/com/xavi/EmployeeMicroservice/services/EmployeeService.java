package com.xavi.EmployeeMicroservice.services;

import com.xavi.EmployeeMicroservice.dao.EmployeeRepository;
import com.xavi.EmployeeMicroservice.dto.EmployeeDto;
import com.xavi.EmployeeMicroservice.exceptions.UserAlreadyExistsException;
import com.xavi.EmployeeMicroservice.exceptions.UserNotFoundException;
import com.xavi.EmployeeMicroservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    //#####################################
    /**
     *Convert Entity to Dto
     */
    public EmployeeDto convertEntityToDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setNationalId(employee.getNationalId());
        employeeDto.setUsername(employeeDto.getUsername());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setRole(employee.getRole());

     return employeeDto;
}
    /**
     *Convert Dto to Entity
     */
    public Employee convertDtoToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();

        employee.setNationalId(employeeDto.getNationalId());
        employee.setUsername(employeeDto.getUsername());
        employee.setEmail(employeeDto.getEmail());
        employee.setRole(employeeDto.getRole());
        return employee;
    }
    //######################################

    // get all employees
    public List<EmployeeDto> getAllEmployees(){
        return  employeeRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
    //add an employee
    public ResponseEntity<Employee> addEmployee(EmployeeDto employeeDto) throws UserAlreadyExistsException {
        Long nationalId = employeeDto.getNationalId();
        //check if the employee national id exists before adding an employee
        employeeRepository.findById(nationalId).ifPresent(
                s -> {
                    try {
                        throw new UserAlreadyExistsException("Employee with the same id " + " " + nationalId + " " +
                                "already exist");
                    } catch (UserAlreadyExistsException e) {
                        throw new RuntimeException(e);
                    }
                }
        );
        Employee employee = convertDtoToEntity(employeeDto);
        employeeRepository.save(employee);

        return ResponseEntity.ok().body(employee);
    }

    //find an employee
    public ResponseEntity<EmployeeDto> findAnEmployee(Long nationalId) throws UserNotFoundException {
        Employee employee = employeeRepository.findById(nationalId)
                .orElseThrow(() -> new UserNotFoundException("Employee with id" + ":: " + nationalId + "  not found"));

        EmployeeDto employeeDto = convertEntityToDto(employee);

        return ResponseEntity.ok().body(employeeDto);
    }
        //delete an employee
    public Map<String, Boolean> deleteEmployee(Long nationalId) throws UserNotFoundException {
        Employee employee = employeeRepository.findById(nationalId)
                .orElseThrow(() -> new UserNotFoundException("Employee with id" + ":: " + nationalId + "  not found"));

        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("employee deleted", Boolean.TRUE);

        return response;

    }
    //update employee
    public ResponseEntity<EmployeeDto> updateEmployee (EmployeeDto employeeDto, Long nationalId) throws UserNotFoundException {
       Employee employee = employeeRepository.findById(nationalId)
                .orElseThrow(() -> new UserNotFoundException("Employee with id" + ":: " + nationalId + "  not found"));

       employee.setNationalId(employeeDto.getNationalId());
       employee.setUsername(employeeDto.getUsername());
       employee.setEmail(employeeDto.getEmail());
       employee.setRole(employeeDto.getRole());

       //save the entity to db
        employeeRepository.save(employee);
        //convert entity to dto
       final EmployeeDto updatedEmployeeDto = convertEntityToDto(employee);

       return ResponseEntity.ok().body(updatedEmployeeDto);

    }


}
