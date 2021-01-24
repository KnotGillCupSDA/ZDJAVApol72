package com.sda.testingbasics.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTDDExampleTest {

    @Test
    void thatWeCanAddTwoPositiveNumbers() {

        //given
        Calculator calculator = new Calculator();
        double a = 5.0;
        double b = 6.0;
        double expected = 11.0;

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }

    @ParameterizedTest
    @CsvSource({"5, 120", "0, 1", "1, 1"})
    void thatWeCanCalculateFactorial(int number, int expected) {
        Calculator calculator = new Calculator();

        int factorial = calculator.factorial(number);

        Assertions.assertEquals(expected, factorial);
    }

    @Test
    void thatWeCantCalculateFactorialForBigNumbers() {
        Calculator calculator = new Calculator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.factorial(100));
    }
}