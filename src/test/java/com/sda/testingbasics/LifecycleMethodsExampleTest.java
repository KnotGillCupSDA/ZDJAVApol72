package com.sda.testingbasics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifecycleMethodsExampleTest {

    @BeforeEach
    void setUp() {
        System.out.println("Method called before each test-method");
    }

    @Test
    void myFirstTestMethod() {
        System.out.println("My first test method");
    }

    @Test
    void mySecondTestMethod() {
        System.out.println("My second test method");
    }
}
