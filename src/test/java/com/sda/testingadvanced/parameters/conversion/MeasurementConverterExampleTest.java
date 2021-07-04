package com.sda.testingadvanced.parameters.conversion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class MeasurementConverterExampleTest {

	private MeasurementConverter measurementConverter;

	@BeforeEach
	void setUp() {
		measurementConverter = new MeasurementConverter();
	}

	@ParameterizedTest
	@EnumSource
	void shouldAlwaysConvertToDoubleWithinBoundaries(ConversionType conversionType) {
		assertTrue(measurementConverter.convert(10.0, conversionType) < Double.MAX_VALUE);
		assertTrue(measurementConverter.convert(10.0, conversionType) > Double.MIN_VALUE);
		assertNotEquals(Double.NaN, measurementConverter.convert(10.0, conversionType));
	}

	@ParameterizedTest
	@EnumSource(value = ConversionType.class, names = { "METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS" })
	void shouldConvertToHigherValue(ConversionType conversionType) {
		final int value = new Random().nextInt(1000);
		assertTrue(measurementConverter.convert(value, conversionType) > value);
	}

	@ParameterizedTest
	@MethodSource("reversibleOperators")
	void someOperationsShouldBeReversible(ConversionType c1, ConversionType c2) {
		final double value = 10.0;
		final double intermediate = measurementConverter.convert(value, c1);
		assertEquals(value, measurementConverter.convert(intermediate, c2));
	}

	private static Stream<Arguments> reversibleOperators() {
		return Stream.of(
				Arguments.of(ConversionType.CENTIMETERS_TO_INCHES, ConversionType.INCHES_TO_CENTIMETERS),
				Arguments.of(ConversionType.KILOMETERS_TO_MILES, ConversionType.MILES_TO_KILOMETERS),
				Arguments.of(ConversionType.METERS_TO_YARDS, ConversionType.YARDS_TO_METERS)
		);
	}

	@ParameterizedTest
	@EnumSource
	void shouldThrowExceptionForNegativeNumbers(ConversionType conversionType) {
		assertThrows(IllegalArgumentException.class,
				() -> measurementConverter.convert(-3.0, conversionType));
	}
}