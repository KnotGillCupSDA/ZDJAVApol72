package com.sda.testingadvanced.parameters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerExampleTest {

	@ParameterizedTest
	@ValueSource(ints = {3, 6, 9, 27, 12})
	void shouldBeDivisibleBy3(int number) {
		assertTrue(DivisibilityChecker.isDivisibleBy3(number));
	}
}