package com.cg.pl;

import com.cg.service.EmployeeService;
import com.cg.dao.IEmployeeService;

public class EmployeeMain {
    public static void main(String[] args) {
        IEmployeeService es=new EmployeeService();
//        String result=es.createEmployee(new Employee("Robinoff", "Senior HR", "Nagpur", "Good"));
//        System.out.println(result);
        System.out.println(es.removeEmployee("Rob995"));

    }
}
