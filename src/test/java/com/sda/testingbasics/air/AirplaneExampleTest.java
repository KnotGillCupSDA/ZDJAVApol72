package com.sda.testingbasics.air;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneExampleTest {

    @Test
    void shouldBeAbleToAscent() {
        Airplane airplane = new Airplane();

        int expectedHeight = 104;
        airplane.ascent(expectedHeight);

        assertEquals(expectedHeight, airplane.getHeight());
    }

    @Test
    void thatWeCantGoBelowZero() {
        Airplane airplane  = new Airplane();
        airplane.ascent(100);

        airplane.descent(200);

        assertEquals(0, airplane.getHeight());
    }
}