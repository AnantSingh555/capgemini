package com.cg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class EmployeeDTO {
    private int employeeId;
//    @Email
    @NotNull(message="Name is required")
    @NotBlank(message="Enter valid name")
    private String fullName;
    private LocalDate dateOfBirth;
    @NotNull(message="Salary is required")
    @Min(value=10000)
    private Double salary;

    public EmployeeDTO(){}

    public EmployeeDTO(String fullName, LocalDate dateOfBirth, Double salary) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
