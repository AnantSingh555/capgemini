package com.cg.main;

import com.cg.bean.Employee;
import com.cg.cfg.MyConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= new AnnotationConfigApplicationContext(MyConfig.class);
        Employee e=ctx.getBean(Employee.class);
        e.printEmployeeDetails();
        ctx.close();
    }


}
