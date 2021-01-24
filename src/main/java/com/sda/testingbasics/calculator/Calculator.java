package com.sda.testingbasics.calculator;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

    public int factorial(int number) {
        if (number >= 100) {
            throw new IllegalArgumentException();
        }
        if(number <= 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }
}
