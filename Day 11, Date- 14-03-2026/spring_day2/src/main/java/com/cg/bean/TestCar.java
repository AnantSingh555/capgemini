package com.cg.bean;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TestCar {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= new ClassPathXmlApplicationContext("bean.xml");
        Car c=ctx.getBean("car", Car.class);
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter Engine type(petrol/cng): ");
//        String eType=sc.next();
//        System.out.println("Enter Tyre Choice(mrf/jk):");
//        String tType=sc.next();
//        IEngine e=ctx.getBean(eType, IEngine.class);
//        ITyre t=ctx.getBean(tType, ITyre.class);
//        c.setEngine(e);
//        c.setTyre(t);
//        c.setName("Alto");
        c.printCar();
        ctx.close();

    }
}
