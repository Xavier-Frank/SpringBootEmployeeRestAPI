package com.xavi.EmployeeMicroservice.exceptions;

/**
 * Author: oduorfrancis134@gmail.com;
 * MyFile: Wednesday 17/08/2022
 **/
public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String message){
        super (message);
    }
}
