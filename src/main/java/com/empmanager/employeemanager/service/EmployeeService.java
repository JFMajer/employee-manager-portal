package com.empmanager.employeemanager.service;

import com.empmanager.employeemanager.domain.Employee;
import com.empmanager.employeemanager.domain.EmployeeAlreadyExists;
import com.empmanager.employeemanager.domain.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.findEmployeeByEmail(employee.email()).isPresent()) {
            throw new EmployeeAlreadyExists("Employee with email " + employee.email() + " already exists");
        }
        return employeeRepository.save(employee);
    }


}
