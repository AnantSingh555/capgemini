package com.cg.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    @JsonFormat(pattern="dd-MMM-yyyy")
    private LocalDate dob;
    private double salary;

    public Employee(){}
    public Employee(String name, LocalDate dob, double salary) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
