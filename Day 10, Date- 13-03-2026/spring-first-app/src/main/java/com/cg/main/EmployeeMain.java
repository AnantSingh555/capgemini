package com.cg.main;

import com.cg.bean.Address;
import com.cg.bean.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
//        Employee emp=new Employee();
////        emp.setAddress(new Address());
//        emp.printEmployeeDetails();

        ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        Employee emp=ctx.getBean("e", Employee.class);
        emp.printEmployeeDetails();
        ctx.close();
    }
}
