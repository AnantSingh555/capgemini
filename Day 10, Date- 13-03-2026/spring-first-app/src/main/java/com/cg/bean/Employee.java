package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private int empid;
    private String name;
    @Autowired
    @Qualifier("add1")
    private Address address;

    public Employee(int empid, String name, Address address) {
        this.empid = empid;
        this.name = name;
        this.address = address;
    }

    public int getEmpid() {
        return empid;
    }
    public void setEmpid(int empid) {
        this.empid = empid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void printEmployeeDetails(){
        System.out.println("Employee id: "+ empid);
        System.out.println("Employee name: "+ name);
        System.out.println("========Address=======");
        System.out.println("City "+ address.getCity());
        System.out.println("Country "+ address.getCountry());
        System.out.println("Zip "+ address.getZip());
    }
}
