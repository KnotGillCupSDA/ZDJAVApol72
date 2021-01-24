package com.sda.testingbasics.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorExampleTest {

    @Test
    void thatWeCanAddTwoPositiveNumbers(double a, double b, double expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }

    @Test
    void thatWeCanAddTwoNegativeNumbers() {

        //given
        Calculator calculator = new Calculator();
        double a = -4.0;
        double b = -3.0;
        double expected = -7.0;

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }

    @Test
    void thatWeCanAddPositiveAndNegativeNumbers() {

        //given
        Calculator calculator = new Calculator();
        double a = -4.0;
        double b = 3.0;
        double expected = -1.0;

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }
}