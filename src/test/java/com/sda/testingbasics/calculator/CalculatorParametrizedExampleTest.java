package com.sda.testingbasics.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorParametrizedExampleTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({"3.0, 2.0, 5.0", "-1.0, -2.0, -3.0", "5.0, -3.0, 2.0", "1.0, -1.0, 0.0"})
    void addShouldWork(double a, double b, double expected) {

        //when
        double sum = calculator.add(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }

    private static Stream<Arguments> subtractData() {
        return Stream.of(
                Arguments.of(5.0, 3.0, 2.0),
                Arguments.of(4.0, 7.0, -3.0),
                Arguments.of(-4.0, -7.0, 3.0),
                Arguments.of(-4.0, -4.0, 0.0),
                Arguments.of(-4, 4, -8)
        );
    }
    @ParameterizedTest
    @MethodSource("subtractData")
    void subtractShouldWork(double a, double b, double expected) {

        //when
        double sum = calculator.subtract(a, b);

        //then
        assertEquals(expected, sum, a + " + " + b + " should be " + expected);
    }
}