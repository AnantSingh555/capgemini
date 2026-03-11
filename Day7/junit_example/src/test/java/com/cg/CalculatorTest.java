package com.cg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void callTest(){
        Calculator cal= new Calculator();
        assertEquals(12, cal.calculate(9,3));
    }
    @Test
    public void isPrimeTest(){
        Calculator cal=new Calculator();
        assertTrue(cal.isPrime(17));
        assertFalse(cal.isPrime(20));
        assertFalse(cal.isPrime(1));
    }
}
