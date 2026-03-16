package com.cg.entity;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int empId;
    private String name;
    private LocalDate dob;
    private double salary;
//    @Autowired
    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> address;

    public Employee(){}

    public Employee(String name, LocalDate dob, double salary, List<Address> address) {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
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

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void printEmployeeDetails(){
        System.out.println("Employee name: "+ name);
        System.out.println("Employee dob: "+ dob);
        System.out.println("Employee salary: "+ salary);
        System.out.println("========Address List=======");
        for(Address add: address){
            System.out.println("City: " + add.getCity());
            System.out.println("Country: " + add.getCountry());
            System.out.println("Zip: " + add.getZip());
            System.out.println("-------------------");
        }
    }
}
