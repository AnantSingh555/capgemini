package com.cg.bean;

import org.springframework.stereotype.Component;
//here petrol is id of the Component
@Component("petrol")
public class PetrolEngine implements IEngine{
    public String getBHP(){
        return "Petrol Engine with 150 BHP";
    }
}
