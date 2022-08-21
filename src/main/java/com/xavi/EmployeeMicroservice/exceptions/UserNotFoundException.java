package com.xavi.EmployeeMicroservice.exceptions;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Wednesday 17/08/2022
 **/
public class UserNotFoundException extends Throwable{
    public UserNotFoundException(String message){
        super(message);
    }
}
