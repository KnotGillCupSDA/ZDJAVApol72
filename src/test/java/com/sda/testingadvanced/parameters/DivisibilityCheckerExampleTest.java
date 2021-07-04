package com.sda.testingadvanced.parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerExampleTest {

	@ParameterizedTest
	@ValueSource(ints = {3, 6, 9, 27, 12})
	void shouldBeDivisibleBy3(int number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {8, 13, 122})
	void shouldNotBeDivisibleBy3(int number) {
		assertFalse(DivisibilityChecker.isDivisibleBy3(number));
	}

	@ParameterizedTest
	@CsvSource({"3, true", "6, true", "8, false", "13, false"})
	void shouldCheckDivisibilityBy3(int number, boolean expected) {
		assertEquals(expected, DivisibilityChecker.isDivisibleBy3(number));
	}
}