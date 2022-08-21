package com.xavi.EmployeeMicroservice.dao;

import com.xavi.EmployeeMicroservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Tuesday 16/08/2022
 **/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
