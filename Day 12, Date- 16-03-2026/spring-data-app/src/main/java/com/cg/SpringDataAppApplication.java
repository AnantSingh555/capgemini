package com.cg;
import java.util.*;
import com.cg.entity.Address;
import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataAppApplication.class, args);
        IEmployeeRepo eRepo=ctx.getBean(IEmployeeRepo.class);

        Address a1 = new Address("Noida","India",213540);
        Address a2 = new Address("Mumbai","India",259678);

        Employee emp = new Employee(
                "Ramen",
                LocalDate.of(2002,10,12),
                50000,
                Arrays.asList(a1,a2)
        );
        emp.printEmployeeDetails();
        eRepo.save(emp);

        System.out.println("Employee Created...");
    }
    @Bean
    public Address getBean1(){
        Address add=new Address();
        add.setCity("Noida");
        add.setCountry("India");
        add.setZip(213540);
        return add;
    }
    @Bean
    public Address getBean2(){
        Address add=new Address();
        add.setCity("Mumbai");
        add.setCountry("India");
        add.setZip(259678);
        return add;
    }

}

