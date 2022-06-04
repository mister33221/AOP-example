package com.AOPExample.AOPExample.service.serviceImpl;


import com.AOPExample.AOPExample.model.Employee;
import com.AOPExample.AOPExample.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee createEmployee(String name, String empId) {

        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmpId(empId);
        return emp;
    }

    @Override
    public void deleteEmployee(String empId) {

    }

    @Override
    public String printHello() {
        return "Hello world!";
    }
}
