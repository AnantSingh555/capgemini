package com.cg.bean;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeService {
    private List<Employee> employeeList;

    public EmployeeService(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Employee getEmployeeById(int id) {
        for(Employee e: employeeList){
            if(e.getEmployeeId()==id) return e;
        }
        return null;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
