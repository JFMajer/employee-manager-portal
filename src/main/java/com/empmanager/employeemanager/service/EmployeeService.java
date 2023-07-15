package com.empmanager.employeemanager.service;

import com.empmanager.employeemanager.domain.Employee;
import com.empmanager.employeemanager.domain.EmployeeAlreadyExists;
import com.empmanager.employeemanager.domain.EmployeeRepository;
import com.empmanager.employeemanager.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // add employee
    public Employee addEmployee(Employee employee) {
        if (employeeRepository.findEmployeeByEmail(employee.email()).isPresent() || employeeRepository.findEmployeeById(employee.id()).isPresent()) {
            throw new EmployeeAlreadyExists("Employee with email " + employee.email() + "and ID" + employee.id() + " already exists");
        }
        return employeeRepository.save(employee);
    }

    // return list of all employees
    public Iterable<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    // update employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // delete employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // find employee by id
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("Employee with id " + id + " does not exist"));
    }

    // find employee by email
    public Employee findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email).orElseThrow(() -> new UserNotFoundException("Employee with email " + email + " does not exist"));
    }

}
