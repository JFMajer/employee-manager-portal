package com.empmanager.employeemanager.controller;

import com.empmanager.employeemanager.domain.Employee;
import com.empmanager.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    private static final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // return all employees
    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees() {
        log.info("Getting all employees");
        return employeeService.findAllEmployees();
    }

    // return employee by id
    @GetMapping("/find/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        log.info("Getting employee with id {}", id);
        return employeeService.findEmployeeById(id);
    }

    // add employee
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@Valid @RequestBody Employee employee) {
        log.info("Saving new employee");
        return employeeService.addEmployee(employee);
    }

    // add multiple employees
    @PostMapping("/addMultiple")
    @ResponseStatus(HttpStatus.CREATED)
    public Iterable<Employee> addMultipleEmployees(@Valid @RequestBody Iterable<Employee> employees) {
        for (Employee employee : employees) {
            log.info("Saving new employee");
            employeeService.addEmployee(employee);
        }
        return employees;
    }

    // update employee
    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody Employee employee) {
        log.info("Updating employee with id {}", id);
        return employeeService.updateEmployee(employee);
    }


    // delete employee
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("id") Long id) {
        log.info("Deleting employee with id {}", id);
        employeeService.deleteEmployee(id);
    }


}
