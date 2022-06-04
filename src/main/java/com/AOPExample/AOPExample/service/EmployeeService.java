package com.AOPExample.AOPExample.service;


import com.AOPExample.AOPExample.model.Employee;

public interface EmployeeService {

    Employee createEmployee(String name, String empId);

    void deleteEmployee(String empId);

    String printHello();
}
