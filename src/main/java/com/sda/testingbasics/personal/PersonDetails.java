package com.sda.testingbasics.personal;

public class PersonDetails {

    private final String name;
    private final String surname;
    private final int age;

    public PersonDetails(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean isChild() {
        return age >= 0 && age <= 10;
    }
}
