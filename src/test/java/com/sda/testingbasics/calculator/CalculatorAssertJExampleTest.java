package com.sda.testingbasics.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalculatorAssertJExampleTest {

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
        //assertEquals(expected, sum, a + " + " + b + " should be " + expected);
        Assertions.assertThat(sum)
                .as(a + " + " + b + " should be " + expected)
                .isEqualTo(expected);

    }
}
