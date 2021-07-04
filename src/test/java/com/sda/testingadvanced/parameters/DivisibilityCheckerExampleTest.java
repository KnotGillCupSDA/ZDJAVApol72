package com.sda.testingadvanced.parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerExampleTest {

	@ParameterizedTest
	@ValueSource(ints = { 3, 6, 9, 27, 12 })
	void shouldBeDivisibleBy3(int number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@MethodSource("numbersDivisibleBy3")
	void shouldBeDivisibleBy3WithMethodSource(int number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	private static Stream<Integer> numbersDivisibleBy3() {
		return Stream.of(3, 6, 9, 27, 12);
	}

	@ParameterizedTest
	@ValueSource(ints = { 8, 13, 122 })
	void shouldNotBeDivisibleBy3(int number) {
		assertFalse(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@CsvSource({ "3, true", "6, true", "8, false", "13, false" })
	void shouldCheckDivisibilityBy3(int number, boolean expected) {
		assertEquals(expected, DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@MethodSource("differentNumbers")
	void shouldCheckDivisibilityBy3WithMethodSource(int number, boolean expected, String errorMessage) {
		assertEquals(expected, DivisibilityChecker.isDivisibleBy3(number), errorMessage);
	}

	private static Stream<Arguments> differentNumbers() {
		return Stream.of(
				Arguments.of(3, true, "3 should be divisible by 3"),
				Arguments.of(6, true, "6 should be divisible by 3"),
				Arguments.of(8, false, "8 should not be divisible by 3"),
				Arguments.of(13, false, "13 should not be divisible by 3")
		);
	}
}