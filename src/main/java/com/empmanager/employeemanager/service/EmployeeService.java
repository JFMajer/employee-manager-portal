package com.empmanager.employeemanager.service;

import com.empmanager.employeemanager.domain.EmployeeRepository;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


}
