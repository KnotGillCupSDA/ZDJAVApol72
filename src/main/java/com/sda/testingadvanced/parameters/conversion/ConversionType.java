package com.sda.testingadvanced.parameters.conversion;

import java.util.function.Function;

public enum ConversionType {
    METERS_TO_YARDS(v -> 1.0936 * v),
    YARDS_TO_METERS(v -> v / 1.0936),
    CENTIMETERS_TO_INCHES(v -> v * 0.39370),
    INCHES_TO_CENTIMETERS(v -> v / 0.39370),
    KILOMETERS_TO_MILES(v -> v * 0.62137),
    MILES_TO_KILOMETERS(v -> v / 0.62137);

    private final Function<Double, Double> converter;

    ConversionType(Function<Double, Double> converter) {
        this.converter = converter;
    }

    public Function<Double, Double> getConverter() {
        return converter;
    }
}
