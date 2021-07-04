package com.sda.testingadvanced.parameters.conversion;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MeasurementConverterExampleTest {

	private MeasurementConverter measurementConverter;

	@BeforeEach
	void setUp() {
		measurementConverter = new MeasurementConverter();
	}

	@ParameterizedTest
	@EnumSource
	void shouldConvertToValuesBelowIntegerMax(ConversionType conversionType) {
		assertTrue(measurementConverter.convert(10.0, conversionType) < Integer.MAX_VALUE);
	}

	@ParameterizedTest
	@EnumSource(value = ConversionType.class, names = { "METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS" })
	void shouldConvertToHigherValue(ConversionType conversionType) {
		final int value = new Random().nextInt(1000);
		assertTrue(measurementConverter.convert(value, conversionType) > value);
	}
}