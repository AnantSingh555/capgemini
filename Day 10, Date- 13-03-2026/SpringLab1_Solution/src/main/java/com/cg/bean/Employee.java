package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
    private int employeeId;
    private String employeeName;
    private double salary;
    private String businessUnit;
    private int age;
    @Autowired
    private SBU sbu;

    public Employee(){};

    public Employee(String employeeName, int employeeId, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printEmployeeDetails(){
        System.out.println("Employee Details");
        System.out.println("-----------------------------");
        System.out.println("Employee ID : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Employee Salary : " + salary);
        System.out.println("Employee BU : " + businessUnit);
        System.out.println("Employee Age : " + age);
    }
    public void getSbuDetails(){
        System.out.println("Employee Details");
        System.out.println("-----------------------------");
        System.out.printf("Employee [empAge=%d, empID=%d, empName=%s, empSalary=%.2f \n " +
                "sbu details=SBU [sbuCode=%s, sbuHead=%s, sbuName=%s]]", age, employeeId, employeeName, salary, sbu.getsBuId(), sbu.getSbuHead(), sbu.getSbuName());
    }

    @Override
    public String toString(){
        return "Employee [empAge="+age+", empId="+employeeId+", empName="+employeeName+", empSalary="+salary+"]";
    }

}
