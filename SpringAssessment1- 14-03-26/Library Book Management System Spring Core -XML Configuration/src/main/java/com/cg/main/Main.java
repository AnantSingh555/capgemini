package com.cg.main;

import com.cg.bean.Librarian;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        Librarian lib=ctx.getBean("lib", Librarian.class);
        lib.issueBook();
        ctx.close();
    }
}
