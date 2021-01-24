package com.sda.testingbasics.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorExampleTest {

    @Test
    void thatWeCanAddTwoPositiveNumbers() {
        //given
        Calculator calculator = new Calculator();
        double a = 2.0;
        double b = 3.0;
        double expected = 5.0;

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }
}