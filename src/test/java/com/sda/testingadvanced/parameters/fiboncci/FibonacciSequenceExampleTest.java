package com.sda.testingadvanced.parameters.fiboncci;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciSequenceExampleTest {

	@ParameterizedTest
	@MethodSource("provideImplementations")
	void shouldCalculateFibonacciNthElement(FibonacciSequence fibonacciSequence) {
		assertEquals(BigInteger.ZERO, fibonacciSequence.getFibonacciNumber(0));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(1));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(2));

		assertEquals(new BigInteger("701408733"),
				fibonacciSequence.getFibonacciNumber(44));
	}

	@ParameterizedTest
	@MethodSource("provideImplementations")
	void shouldThrowsExceptionForNegativeNumbers(FibonacciSequence fibonacciSequence) {
		// JUnit5
		assertThrows(IllegalArgumentException.class, () -> fibonacciSequence.getFibonacciNumber(-4));

		//AssertJ
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> fibonacciSequence.getFibonacciNumber(-4));
	}

	private static Stream<FibonacciSequence> provideImplementations() {
		return Stream.of(new FibonacciSequenceRecursive(), new FibonacciSequenceIterative());
	}
}