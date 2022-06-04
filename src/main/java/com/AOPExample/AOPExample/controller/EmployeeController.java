package com.AOPExample.AOPExample.controller;


import com.AOPExample.AOPExample.model.Employee;
import com.AOPExample.AOPExample.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
//@Controller
public class EmployeeController {


    private EmployeeService employeeService;
    private static Logger myLogger = Logger.getLogger(EmployeeController.class.getName());


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloWorld() {
        myLogger.info("myLogger.info : "+employeeService.printHello());
        return employeeService.printHello();

    }

    @RequestMapping(value = "/add/employee", method = RequestMethod.GET)
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("empId") String empId) {

        return employeeService.createEmployee(name, empId);

    }

    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee( @RequestParam("empId") String empId) {

        employeeService.deleteEmployee(empId);

        return "Employee removed";
    }

}
