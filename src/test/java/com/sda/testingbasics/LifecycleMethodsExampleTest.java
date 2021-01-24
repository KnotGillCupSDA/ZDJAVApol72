package com.sda.testingbasics;

import org.junit.jupiter.api.*;

public class LifecycleMethodsExampleTest {

    @BeforeEach
    void setUp() {
        System.out.println("Method called before each test-method");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Method called after each test-method");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Method called once before all test-methods");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Method called once after all test-methods");
    }

    @Test
    void myFirstTestMethod() {
        System.out.println("My first test method");
    }

    @Test
    void mySecondTestMethod() {
        System.out.println("My second test method");
    }

    @Test
    void myThirdTestMethod() {
        System.out.println("My third test method");
    }
}
