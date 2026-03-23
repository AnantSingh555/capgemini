package com.cg;

public class CalculatorMain {
    public static void main(String[] args) {
        ICalculator c=(x,y)->x+y;
        CalculatorService cService=new CalculatorService(c);
        System.out.println(cService.addService(10,5));
    }
}
