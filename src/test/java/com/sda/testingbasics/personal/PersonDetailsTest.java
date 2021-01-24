package com.sda.testingbasics.personal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonDetailsTest {

    @Test
    void thatPersonIsAChild() {
        PersonDetails personDetails = new PersonDetails("Tomek", "Wozniak", 5);
        Assertions.assertTrue(personDetails.isChild());
    }
}