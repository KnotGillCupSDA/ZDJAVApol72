package com.sda.testingbasics.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorParametrizedExampleTest {

    @ParameterizedTest
    @CsvSource({"3.0, 2.0, 5.0", "-1.0, -2.0, -3.0", "5.0, -3.0, 2.0", "1.0, -1.0, 0.0"})
    void thatWeCanAddTwoPositiveNumbers(double a, double b, double expected) {

        //given
        Calculator calculator = new Calculator();

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }

}