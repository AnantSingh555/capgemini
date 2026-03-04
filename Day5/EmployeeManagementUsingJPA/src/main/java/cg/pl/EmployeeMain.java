package cg.pl;


import cg.bean.Employee;
import cg.dao.IEmployeeService;
import cg.service.EmployeeService;

import java.util.List;

public class EmployeeMain {
    public static void main(String[] args) {
        IEmployeeService es=new EmployeeService();
        String result=es.createEmployee(new Employee("Robinoff", "Senior HR", "Nagpur", "Good"));
        System.out.println(result);

        Employee e1 = es.findById("E101");
        System.out.println(e1);

        System.out.println(es.updateEmployeeName("E101", "Anant Singh"));

        List<Employee> list = es.getAllEmployee();
        list.forEach(System.out::println);

        System.out.println(es.removeEmployee("Rob995"));

    }
}
