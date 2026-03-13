package com.cg.main;

import com.cg.bean.Employee;
import com.cg.bean.SBU;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        Employee emp=ctx.getBean("e", Employee.class);
//        Problem Statement 1.1
        emp.printEmployeeDetails();
        System.out.println();
//        Problem Statement 1.2
        emp.getSbuDetails();
        System.out.println();
        System.out.println();
//        Problem Statement 1.3
        SBU sbu=ctx.getBean("sbu", SBU.class);
        sbu.printSbuDetailsWithList();
        ctx.close();
    }
}
