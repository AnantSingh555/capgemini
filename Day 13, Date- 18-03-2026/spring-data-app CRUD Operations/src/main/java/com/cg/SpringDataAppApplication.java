package com.cg;
import java.util.*;
import com.cg.entity.Address;
import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import com.cg.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

@SpringBootApplication
public class SpringDataAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx=SpringApplication.run(SpringDataAppApplication.class, args);
        EmployeeService es=ctx.getBean(EmployeeService.class);
//        IEmployeeRepo eRepo=ctx.getBean(IEmployeeRepo.class);

        Address a1 = new Address("Noida","India",213540);
        Address a2 = new Address("Mumbai","India",259678);

        Employee emp = new Employee(
                "Ramen",
                LocalDate.of(2002,1,12),
                50000,
                Arrays.asList(a1,a2)
        );
        emp.printEmployeeDetails();
//        eRepo.save(emp);
//
//        System.out.println("Employee Created...");
        Scanner sc=new Scanner(System.in);
        System.out.println(es.createEmployee(emp));
//        es.getEmployeeByName("Ramen").forEach(e->System.out.println(e));

//        es.getEmployeeBySalary(50000).forEach(e-> System.out.println(e));
        es.getEmployeeByMonth(1).forEach(e-> System.out.println(e));


//        es.getEmployees().forEach(System.out::println);

//
//        System.out.println("Do you want to remove employee: yes/no?");
//        String choice=sc.nextLine();
//        if(choice.equals("yes")){
//            System.out.println("Enter the id to remove :" );
//            int eId=sc.nextInt();
//            es.removeEmployee(eId);
//        }
//
//        Employee e=es.getEmployee(1);
//        if(e!=null){
//            e.setDob(LocalDate.of(2004, 10, 12));
//            System.out.println(es.updateEmployee(e));
//        }

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

