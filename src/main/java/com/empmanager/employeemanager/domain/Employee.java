package com.empmanager.employeemanager.domain;

import org.springframework.data.annotation.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

public record Employee(
    @Id
    Long id,
    @NotBlank(message = "Name is mandatory")
    String name,
    String email,
    String jobTitle,
    String phone,
    String imageUrl,
    String employeeCode
) {
}
