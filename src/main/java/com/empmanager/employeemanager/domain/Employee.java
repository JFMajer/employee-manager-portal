package com.empmanager.employeemanager.domain;

import org.springframework.data.annotation.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

public record Employee(
    @Id
    Long id,
    @NotBlank(message = "Name is mandatory")
    String name,
    @NotBlank(message = "Email is mandatory")
    String email,
    @NotBlank(message = "Job title is mandatory")
    String jobTitle,
    @NotBlank(message = "Phone is mandatory")
    String phone,
    String imageUrl,
    @NotBlank(message = "Employee code is mandatory")
    String employeeCode,
    @CreatedDate
    Instant createdDate,
    @LastModifiedDate
    Instant lastModifiedDate
) {
    public static Employee of(
        Long id,
        String name,
        String email,
        String jobTitle,
        String phone,
        String imageUrl,
        String employeeCode,
        Instant createdDate,
        Instant lastModifiedDate
    ) {
        return new Employee(
            id,
            name,
            email,
            jobTitle,
            phone,
            imageUrl,
            employeeCode,
            createdDate,
            lastModifiedDate
        );
    }
}
