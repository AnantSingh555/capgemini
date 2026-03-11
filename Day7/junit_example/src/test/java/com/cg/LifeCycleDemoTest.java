package com.cg;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LifeCycleDemoTest {
    static Calculator calculator;
    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all the test cases");
        calculator =new Calculator();
        return;
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("Before each test cases");
    }
    @Test
    void TestCalculate(){
        assertEquals(34, calculator.calculate(20,14));
        assertEquals(4, calculator.calculate(2,2));
    }
    @Test
    void TestIsPrime(){
        assertTrue(calculator.isPrime(3));
        assertFalse(calculator.isPrime(6));
        assertFalse(calculator.isPrime(8));
    }
    @AfterEach
    void afterEach(){
        System.out.println("Executed after each test cases.");
    }
    @AfterAll
    static void afterAll(){
        System.out.println("Executed after all test cases.");
    }
}
