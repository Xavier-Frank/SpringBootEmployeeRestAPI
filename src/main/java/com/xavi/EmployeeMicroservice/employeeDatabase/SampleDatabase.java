package com.xavi.EmployeeMicroservice.employeeDatabase;

import com.xavi.EmployeeMicroservice.dao.EmployeeRepository;
import com.xavi.EmployeeMicroservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static com.xavi.EmployeeMicroservice.model.Role.MANAGER;
import static com.xavi.EmployeeMicroservice.model.Role.WORKER;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Thursday 15/09/2022
 **/
@Configuration
public class SampleDatabase   {

    private static final Logger logger = LoggerFactory.getLogger(SampleDatabase.class);

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository ){
        return args -> {
            employeeRepository.deleteAll();
            logger.info("Adding 1st Employee" + "...." + employeeRepository.save(new Employee(37900889L,
                    "john kelly", "oduorfrancis134@gmail.com", MANAGER )));
            logger.info("Adding 2nd Employee" + "...." + employeeRepository.save(new Employee(4567890L,
                    "ken owino", "owinoken@gmail.com", WORKER)));
            logger.info("Adding  3rd Employee" + "...." + employeeRepository.save( new Employee(34567890L,
                    "grace njoki", "njokigrace@gmail.com", WORKER)));
            logger.info("Adding 4th Employee" + "...." + employeeRepository.save(new Employee(8978756L,
                    "janet jany", "janyjanet@gmail.com", MANAGER)));
            logger.info("Adding 5th Employee " + "...." + employeeRepository.save(new Employee(34567893L,
                    "benard mikey", "mieybenard@gmail.com", WORKER)));
        };
    }



}
